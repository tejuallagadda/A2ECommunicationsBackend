package com.a2e.collaboration.service;

import com.a2e.collaboration.commons.A2EErrorCode;
import com.a2e.collaboration.commons.Secret;
import com.a2e.collaboration.controllers.request.A2ERequest;
import com.a2e.collaboration.controllers.request.commons.CallerInfo;
import com.a2e.collaboration.controllers.response.UserResponse;
import com.a2e.collaboration.model.UserDTO;
import com.a2e.collaboration.model.UserRepository;
import com.a2e.collaboration.service.validation.A2EException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by tejaswini.a on 03/05/20.
 */

@Service("authService")
public class AuthService {
    @Autowired
            private UserRepository userRepository;
    Logger logger = LogManager.getLogger(AuthService.class);

    public void authorizeApp(A2ERequest a2ERequest) throws A2EException {
        logger.info("Inside AuthService isAuthorized callerInfo :" + a2ERequest);
        CallerInfo callerInfo = a2ERequest.getCallerInfo();
        if (callerInfo != null) {
            if(callerInfo.getAppKey().equals("12345")){
                return;
            }
        }
        throw new A2EException(A2EErrorCode.APP_NOT_AUTHORIZED);
    }

    public void authenticateOTP(String email, String otp) throws A2EException {
        //TODO
        List<UserDTO> users = userRepository.findByEmail(email);
        if(users.size() != 1)
            throw new A2EException(A2EErrorCode.USER_NOT_FOUND);
        UserDTO user = users.get(0);
        if(user.getUniqueCode().equals(otp)){
            Calendar date =Calendar.getInstance();
            if(user.getUniqueCodeExpiration().before(date.getTime())){
                throw new A2EException(A2EErrorCode.OTP_EXPIRED);
            }
        }
        else{
            throw new A2EException(A2EErrorCode.INVALID_OTP);
        }
    }
    public void authenticatePassword(String email, String password) throws A2EException {
        //TODO
        List<UserDTO> users = userRepository.findByEmail(email);
        if(users.size() != 1)
            throw new A2EException(A2EErrorCode.USER_NOT_FOUND);
        UserDTO user = users.get(0);
        if(user.getPassword().equals(password)){
            user.setLastLogin(new Date());
            userRepository.save(user);
        } else {
            throw new A2EException(A2EErrorCode.INVALID_PASSWORD);
        }
    }
}
