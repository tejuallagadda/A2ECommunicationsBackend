package com.a2e.collaboration.controllers;

import com.a2e.collaboration.login.loginVO.LoginRequest;
import com.a2e.collaboration.login.loginVO.LoginResponse;
import com.a2e.collaboration.login.service.LoginService;
import com.a2e.collaboration.user.Request.UserRequestObject;
import com.a2e.collaboration.user.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by tejaswini.a on 02/05/20.
 */

@RestController
public class LoginController {

    Logger logger = LogManager.getLogger(LoginController.class);

    @Resource(name = "loginService")
    private LoginService loginService;

    @PostMapping(value = "/login", consumes = "application/json")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        logger.info("Inside login controller loginRequest"+loginRequest);
        UserRequestObject user = loginRequest.getLogin();
        if(user.getEmail() == null || user.getSecret()==null || user.getSecret().getPassword()==null)
        {
            return new LoginResponse(400,111,"Incorrect email or Password");
        }
        User userResp =  loginService.login(user);
        logger.info("Inside login controller userResp"+userResp);
        if(userResp!=null) {
            return new LoginResponse(200, 104, "User logged in successfully", userResp);
        }
        return new LoginResponse(400,111,"Incorrect email or Password");
    }
}
