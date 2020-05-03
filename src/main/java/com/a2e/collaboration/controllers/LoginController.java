package com.a2e.collaboration.controllers;

import com.a2e.collaboration.general.service.AuthService;
import com.a2e.collaboration.login.loginVO.LoginRequest;
import com.a2e.collaboration.general.response.FinalResponse;
import com.a2e.collaboration.login.service.LoginService;
import com.a2e.collaboration.user.Request.User;
import com.a2e.collaboration.user.model.UserDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by tejaswini.a on 02/05/20.
 */

@CrossOrigin(methods = RequestMethod.POST)
@RestController
public class LoginController {

    Logger logger = LogManager.getLogger(LoginController.class);

    @Resource(name = "loginService")
    private LoginService loginService;

    @Resource(name = "authService")
    private AuthService authService;

    //TODO write enum file for error codes;
    @PostMapping(value = "/login", consumes = "application/json")
    public FinalResponse login(@RequestBody LoginRequest loginRequest){
        if(!authService.isAppAuthorized(loginRequest.getCallerInfo())){
            return new FinalResponse(401,114,"Unauthorized request");
        }
        logger.info("Inside login controller loginRequest"+loginRequest);
        User user = loginRequest.getLogin();
        if(user.getEmail() == null || user.getSecret()==null || user.getSecret().getPassword()==null)
        {
            return new FinalResponse(400,111,"Incorrect email or Password");
        }
        UserDTO userResp =  loginService.login(user);
        logger.info("Inside login controller userResp"+userResp);
        if(userResp!=null) {
            return new FinalResponse(200, 104, "User logged in successfully", userResp);
        }
        return new FinalResponse(400,111,"Incorrect email or Password");
    }
}
