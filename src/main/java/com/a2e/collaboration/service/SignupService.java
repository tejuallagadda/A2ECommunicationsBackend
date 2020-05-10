package com.a2e.collaboration.service;

import com.a2e.collaboration.commons.A2EErrorCode;
import com.a2e.collaboration.controllers.commons.UserDTO;
import com.a2e.collaboration.controllers.request.UserRequest;
import com.a2e.collaboration.controllers.response.UserResponse;
import com.a2e.collaboration.model.User;
import com.a2e.collaboration.service.mapping.Mapping;
import com.a2e.collaboration.model.UserRepository;
import com.a2e.collaboration.service.validation.A2EException;
import com.a2e.collaboration.service.validation.UserValidation;
import com.a2e.collaboration.service.validation.Validation;
import com.a2e.collaboration.service.validation.ValidationException;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
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

    //TODO use autowire instead of new to create an object
    //TODO create validation error method seperately
    //TODO add new layer for validation
    public UserResponse createProspectUser(UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        logger.info("Inside SignupService saveProspectUser() : "+userRequest.toString());
        try {
            authService.authorizeApp(userRequest);
            validation.validateSignUpPage(userRequest);
        } catch(A2EException a2eException){
            userResponse.setError(a2eException.getA2EErrorCode());
            //TODO Map userrequest to userresponse
            return userResponse;
        }

        User userDto = getNewUser(userRequest.getUser());
        userRepository.save(userDto);
        userResponse.setSuccess();
        sendMailWithOTP(userDto.getEmail(), userDto.getUniqueCode());
        //TODO Can we set User in the request to User in the response ? or do we need to create new
        // UserResponse and map from UserRequest ?
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

    private User getNewUser(UserDTO userDTO){
        User user = new User();
        mapping.mapUser(userDTO, user);
        Calendar date = Calendar.getInstance();
        user.setCreatedOn(date.getTime());
        user.setIsAactive(true);
        user.setIsProspect(true);
        user.setUpdatedOn(date.getTime());
        user.setLastLogin(date.getTime());
        Random random = new Random();
        String otp = String.format("%06d", random.nextInt(1000000));
        user.setUniqueCode(otp);
        date.add(Calendar.MINUTE, 15);
        user.setUniqueCodeExpiration(date.getTime());
        return user;
    }

    private void sendMailWithOTP (String emailId, String otp){
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("a2ecollaboration2020@gmail.com(opens in new tab)", "nkvwwpdolqtezeaw"));
            email.setSSLOnConnect(true);
            email.setFrom("teju.allagadda@gmail.com(opens in new tab)");
            email.setSubject("OTP to register in A2E");
            email.setMsg("OTP requested by you is " + otp + "\n This message is computer generated. Please do not reply");
            email.addTo(emailId+"(opens in new tab)");
            email.send();
        } catch(Exception e){
            logger.error("Could not send OTP to the mail address", e);
        }
    }
}
