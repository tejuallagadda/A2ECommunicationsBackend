package com.a2e.collaboration.login.service;

import com.a2e.collaboration.user.Request.UserRequestObject;
import com.a2e.collaboration.user.model.User;
import com.a2e.collaboration.user.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@Service("loginService")
public class LoginService {

    Logger logger = LogManager.getLogger(LoginService.class);

    @Autowired
    private UserRepository userRepository;

    public User login(UserRequestObject user){
        logger.info("Inside login service user"+user);
        User existingUser = userRepository.findByEmail(user.getEmail()).get(0);

        if(user.getSecret().getPassword().equals(existingUser.getPassword())){
            return existingUser;
        }
        return null;
    }
}
