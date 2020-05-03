package com.a2e.collaboration.service;

import com.a2e.collaboration.controllers.request.A2ERequest;
import com.a2e.collaboration.controllers.request.commons.CallerInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by tejaswini.a on 03/05/20.
 */

@Service("authService")
public class AuthService {

    Logger logger = LogManager.getLogger(AuthService.class);

    public Boolean isAppAuthorized(A2ERequest a2ERequest) {
        logger.info("Inside AuthService isAuthorized callerInfo :" + a2ERequest);
        CallerInfo callerInfo = a2ERequest.getCallerInfo();
        if (callerInfo != null) {
            if(callerInfo.getAppKey().equals("12345")){
                return true;
            }
        }
        return false;
    }

}
