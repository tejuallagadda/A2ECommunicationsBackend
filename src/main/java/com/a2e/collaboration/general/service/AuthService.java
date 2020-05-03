package com.a2e.collaboration.general.service;

import com.a2e.collaboration.general.request.A2eRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by tejaswini.a on 03/05/20.
 */

@Service("authService")
public class AuthService {

    Logger logger = LogManager.getLogger(AuthService.class);

    public Boolean isAppAuthorized(A2eRequest callerInfo) {
        logger.info("Inside AuthService isAuthorized callerInfo :"+callerInfo);
        if (callerInfo != null) {
            if(callerInfo.getAppKey().equals("12345")){
                return true;
            }
        }
        return false;
    }

}
