package com.a2e.collaboration.controllers;

import com.a2e.collaboration.controllers.request.UserRequest;
import com.a2e.collaboration.controllers.response.UserResponse;
import com.a2e.collaboration.service.SignupService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@CrossOrigin(methods = RequestMethod.POST)
@RestController
public class SignUpController {

    Logger logger = LogManager.getLogger(SignUpController.class);

    //TODO Difference between Resource and Autowired ?
    @Resource(name = "signupService")
    private SignupService signupService;


    //TODO add routing token as request parameter
    @PostMapping(value = "/signup")
    public @ResponseBody
    UserResponse signup(@RequestBody UserRequest userRequest){
        logger.info("Inside SignUpController signup() signUpRequest :"+userRequest);
        UserResponse userResponse = signupService.createProspectUser(userRequest);
        return new UserResponse(200,signupServiceResponse.getRespCode(),"Email with OTP sent successfully",signupServiceResponse.getUser());
    }

/*    @PostMapping(value = "/signup/otp")
    public  @ResponseBody
    UserResponse otpValidation(@RequestBody UserRequest userRequest){
        logger.info("Inside SignUpController otpValidation() signUpRequest :"+userRequest);
        SignupServiceResponse signupServiceResponse = signupService.verifyOtp(userRequest);
        return new UserResponse(200, signupServiceResponse.getRespCode(), "OTP verified and user created successfully", signupServiceResponse.getUser());
    }

    @PostMapping(value = "/sigup/password")
    public  @ResponseBody
    UserResponse savePassword(@RequestBody UserRequest userRequest){
        logger.info("Inside SignUpController savePassword() signUpRequest :"+userRequest);
        SignupServiceResponse signupServiceResponse = signupService.savePassword(userRequest);
        return new UserResponse(200, signupServiceResponse.getRespCode(), "Password saved successfully", signupServiceResponse.getUser());
    }
*/
}
