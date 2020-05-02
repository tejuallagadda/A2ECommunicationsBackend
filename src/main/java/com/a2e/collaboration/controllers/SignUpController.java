package com.a2e.collaboration.controllers;

import com.a2e.collaboration.general.response.A2eResponse;
import com.a2e.collaboration.login.loginVO.LoginResponse;
import com.a2e.collaboration.login.loginVO.RespDetails;
import com.a2e.collaboration.signp.model.SignupRequest;
import com.a2e.collaboration.user.model.User;
import com.a2e.collaboration.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tejaswini.a on 02/05/20.
 */

@RestController
public class SignUpController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/signup")
    public @ResponseBody LoginResponse signup(@RequestBody SignupRequest signupRequest){
        User user = userRepository.findByEmail("jbdj").get(0);
        return new LoginResponse(new A2eResponse(200,101,"Email with OTP sent successfully"),
                new RespDetails(user));
    }

}
