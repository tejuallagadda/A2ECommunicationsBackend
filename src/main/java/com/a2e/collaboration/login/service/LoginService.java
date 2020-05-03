package com.a2e.collaboration.login.service;

import com.a2e.collaboration.user.Request.User;
import com.a2e.collaboration.user.model.UserDTO;
import com.a2e.collaboration.user.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@Service("loginService")
public class LoginService {

    Logger logger = LogManager.getLogger(LoginService.class);

    @Autowired
    private UserRepository userRepository;

    public UserDTO login(User user){
        logger.info("Inside login service user"+user);
        UserDTO existingUser = userRepository.findByEmail(user.getEmail()).get(0);
        if(user.getSecret().getPassword().equals(existingUser.getPassword())){
            UserDTO user1 = userRepository.findByEmail(user.getEmail()).get(0);
            user1.setLastLogin(new Date());
            userRepository.save(user1);
            return existingUser;
        }
        return null;
    }
}
