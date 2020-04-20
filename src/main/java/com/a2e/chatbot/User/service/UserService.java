package com.a2e.chatbot.User.service;

import com.a2e.chatbot.User.Repository.IUserService;
import com.a2e.chatbot.User.Repository.UserRepository;
import com.a2e.chatbot.User.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tejaswini.a on 20/04/20.
 */
@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll(){
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }
}
