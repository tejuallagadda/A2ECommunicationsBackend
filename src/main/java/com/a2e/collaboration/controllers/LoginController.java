package com.a2e.collaboration.controllers;

import com.a2e.collaboration.service.AuthService;
import com.a2e.collaboration.controllers.request.UserRequest;
import com.a2e.collaboration.controllers.response.UserResponse;
import com.a2e.collaboration.service.LoginService;
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

    //TODO write enum file for error codes;
    @PostMapping(value = "/login", consumes = "application/json")
    public UserResponse login(@RequestBody UserRequest userRequest) {
        logger.info("Inside Login Controller :" + userRequest);
        return loginService.login(userRequest);
    }
}
