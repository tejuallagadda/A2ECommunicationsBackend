package com.a2e.collaboration.controllers;

import com.a2e.collaboration.general.response.FinalResponse;
import com.a2e.collaboration.signup.model.SignupServiceResponse;
import com.a2e.collaboration.signup.model.SignupRequest;
import com.a2e.collaboration.signup.service.SignupService;
import com.a2e.collaboration.user.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@CrossOrigin(methods = RequestMethod.POST)
@RestController
public class SignUpController {

    Logger logger = LogManager.getLogger(SignUpController.class);

    @Autowired
    private UserRepository userRepository;

    @Resource(name = "signupService")
    private SignupService signupService;


    //TODO add routing token as request parameter
    @PostMapping(value = "/signup")
    public @ResponseBody FinalResponse signup(@RequestBody SignupRequest signupRequest){
        logger.info("Inside SignUpController signup() signUpRequest :"+signupRequest);
        SignupServiceResponse signupServiceResponse = signupService.saveProspectUser(signupRequest);
        return new FinalResponse(200,signupServiceResponse.getRespCode(),"Email with OTP sent successfully",signupServiceResponse.getUser());
    }

    @PostMapping(value = "/signup/otp")
    public  @ResponseBody FinalResponse otpValidation(@RequestBody SignupRequest signupRequest){
        logger.info("Inside SignUpController otpValidation() signUpRequest :"+signupRequest);
        SignupServiceResponse signupServiceResponse = signupService.verifyOtp(signupRequest);
        return new FinalResponse(200, signupServiceResponse.getRespCode(), "OTP verified and user created successfully", signupServiceResponse.getUser());
    }

    @PostMapping(value = "/sigup/password")
    public  @ResponseBody FinalResponse savePassword(@RequestBody SignupRequest signupRequest){
        logger.info("Inside SignUpController savePassword() signUpRequest :"+signupRequest);
        SignupServiceResponse signupServiceResponse = signupService.savePassword(signupRequest);
        return new FinalResponse(200, signupServiceResponse.getRespCode(), "Password saved successfully", signupServiceResponse.getUser());
    }

}
