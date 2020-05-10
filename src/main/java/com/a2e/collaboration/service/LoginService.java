package com.a2e.collaboration.service;


import com.a2e.collaboration.controllers.request.UserRequest;
import com.a2e.collaboration.controllers.response.UserResponse;
import com.a2e.collaboration.model.UserRepository;
import com.a2e.collaboration.service.mapping.Mapping;
import com.a2e.collaboration.service.validation.A2EException;
import com.a2e.collaboration.service.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@Service("loginService")
public class LoginService {

    Logger logger = LogManager.getLogger(LoginService.class);
    @Resource(name = "authService")
    private AuthService authService;
    @Autowired
    private Validation validation;

    public UserResponse login(UserRequest userRequest){
        logger.info("Inside login controller loginRequest"+ userRequest);
        UserResponse userResponse = new UserResponse();
        try {
            authService.authorizeApp(userRequest);
            validation.validateLoginPage(userRequest);
            authService.authenticatePassword(userRequest.getUser().getEmail(), userRequest.getUser().getSecret().getPassword());
        } catch(A2EException a2eException){
            userResponse.setError(a2eException.getA2EErrorCode());
            //TODO Map userrequest to userresponse
            return userResponse;
        }
        userResponse.setSuccess();
        userResponse.setUser(userRequest.getUser());
        return userResponse;
    }
}
