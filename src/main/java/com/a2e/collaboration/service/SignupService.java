package com.a2e.collaboration.service;

import com.a2e.collaboration.commons.A2EErrorCode;
import com.a2e.collaboration.controllers.commons.UserDTO;
import com.a2e.collaboration.controllers.request.UserRequest;
import com.a2e.collaboration.controllers.response.UserResponse;
import com.a2e.collaboration.model.User;
import com.a2e.collaboration.service.mapping.Mapping;
import com.a2e.collaboration.model.UserRepository;
import com.a2e.collaboration.service.validation.A2EException;
import com.a2e.collaboration.service.validation.Validation;
import com.a2e.collaboration.service.validation.ValidationException;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by tejaswini.a on 03/05/20.
 */

@Service("signupService")
public class SignupService {

    Logger logger = LogManager.getLogger(SignupService.class);

    @Resource(name = "authService")
    private AuthService authService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Validation validation;
    @Autowired
    private Mapping mapping;
    @Autowired
    private MailService mailService;

    //TODO use autowire instead of new to create an object
    //TODO create validation error method seperately
    //TODO add new layer for validation
    public UserResponse createProspectUser(UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        userResponse.setUser(userRequest.getUser());
        logger.info("Inside SignupService saveProspectUser() : "+userRequest.toString());
        try {
            authService.authorizeApp(userRequest);
            validation.validateSignUpPage(userRequest);
            User user = new User();
            mapping.mapNewUser(userRequest.getUser(),user);
            userRepository.save(user);
            mailService.sendMailWithOTP(user.getEmail(), user.getUniqueCode());
        } catch(A2EException a2eException){
            userResponse.setError(a2eException.getA2EErrorCode());
            //TODO Map userrequest to userresponse
            return userResponse;
        }
        //TODO Can we set User in the request to User in the response ? or do we need to create new
        // UserResponse and map from UserRequest ?
        userResponse.setSuccess();
        userResponse.setUser(userRequest.getUser());
        return userResponse;
    }

    public UserResponse verifyOtp(UserRequest userRequest) {
        logger.info("Inside SignupService verifyOtp() : "+userRequest.toString());
        //TODO new used
        UserResponse userResponse = new UserResponse();
        try {
            authService.authorizeApp(userRequest);
            validation.validateOTPPage(userRequest);
            authService.authenticateOTP(userRequest.getUser().getEmail(), userRequest.getUser().getSecret().getOtp());
        } catch(A2EException a2eException){
            userResponse.setError(a2eException.getA2EErrorCode());
            return userResponse;
        }
        userResponse.setUser(userRequest.getUser());
        userResponse.setSuccess();
        return userResponse;
    }

    public UserResponse savePassword (UserRequest userRequest){
        //TODO new used
        UserResponse userResponse = new UserResponse();
        logger.info("Inside SignupService savePassword() : "+userRequest.toString());
        try {
            authService.authorizeApp(userRequest);
            validation.validateSavePasswordPage(userRequest);
        } catch(A2EException a2eException){
            userResponse.setError(a2eException.getA2EErrorCode());
            //TODO Map userrequest to userresponse
            return userResponse;
        }

        List<User> users = userRepository.findByEmail(userRequest.getUser().getEmail());
        if(users.size() != 1) {
            userResponse.setError(A2EErrorCode.USER_NOT_FOUND);
        }
        User user = users.get(0);
        user.setPassword(userRequest.getUser().getSecret().getPassword());
        user.setIsProspect(false);
        user.setUpdatedOn(new Date());
        //TODO If DB request fails ?
        userRepository.save(user);
        //TODO Map user request to user response ? then password will also be sent?
        userResponse.setUser(userRequest.getUser());
        userResponse.setSuccess();
        return userResponse;
    }
}
