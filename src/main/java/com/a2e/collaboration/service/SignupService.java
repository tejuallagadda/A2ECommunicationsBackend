package com.a2e.collaboration.service;

import com.a2e.collaboration.commons.Utilites;
import com.a2e.collaboration.controllers.response.UserResponse;
import com.a2e.collaboration.controllers.request.UserRequest;
import com.a2e.collaboration.controllers.commons.User;
import com.a2e.collaboration.mapping.SignupMapping;
import com.a2e.collaboration.model.UserDTO;
import com.a2e.collaboration.model.UserRepository;
import com.a2e.collaboration.validation.SignupValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.text.Utilities;
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

    private UserResponse returnObject = new UserResponse();

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SignupValidation signupValidation;
    @Autowired
    private SignupMapping signupMapping;
    //TODO use autowire instead of new to create an object
    //TODO create validation error method seperately
    //TODO add new layer for validation
    public UserResponse createProspectUser(UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        logger.info("Inside SignupService saveProspectUser() : "+userRequest.toString());

        if(!authService.isAppAuthorized(userRequest)) {
            userResponse.setError("APP_NOT_AUTHORIZED");
            return userResponse;
        }
        if(!signupValidation.signupPageValidation(userRequest, userResponse)) {
            return userResponse;
        }
        UserDTO userDTO = new userDTO();
        signupMapping.mapUser(user, userDTO);
        userRepository.save(userDTO);
        userResponse.setSuccess();
        //TODO Can we set User in the request to User in the response ? or do we need to create new
        // UserResponse and map from UserRequest ?
        userResponse.setUser(userRequest.getUser());
    }

    public UserResponse verifyOtp(UserRequest signupRequest){
        logger.info("Inside SignupService verifyOtp() : "+signupRequest.toString());
        if(!authService.isAppAuthorized(signupRequest.getCallerInfo())){return new UserResponse(114);}
        if(signupRequest.getUser() == null || signupRequest.getUser().getEmail() == null){return new UserResponse(106);}
        List<UserDTO> users = userRepository.findByEmail(signupRequest.getUser().getEmail());
        if(users.get(0)!=null){
            UserDTO user = users.get(0);
            if(user.getUniqueCode().equals(signupRequest.getUser().getSecret().getOtp())){
                Calendar date =Calendar.getInstance();
                if(user.getUniqueCodeExpiration().before(date.getTime())){
                    returnObject.setRespCode(102);
                    returnObject.setUser(user);
                }
                return new UserResponse(110);
            }
            else{
                return new UserResponse(109);
            }
        }
        return new UserResponse(115);
    }

    public UserResponse savePassword (UserRequest signupRequest){
        logger.info("Inside SignupService savePassword() : "+signupRequest.toString());
        if(!authService.isAppAuthorized(signupRequest.getCallerInfo())){return new UserResponse(114);}
        if(signupRequest.getUser() == null || signupRequest.getUser().getEmail() == null){return new UserResponse(106);}
        List<UserDTO> users = userRepository.findByEmail(signupRequest.getUser().getEmail());
        if(users.get(0)!=null) {
            UserDTO user = users.get(0);
            user.setPassword(signupRequest.getUser().getSecret().getPassword());
            user.setIsProspect(false);
            user.setUpdatedOn(new Date());
            userRepository.save(user);
            returnObject.setUser(user);
            return new UserResponse(103);
        }
        return new UserResponse(115);
    }
    */

}
