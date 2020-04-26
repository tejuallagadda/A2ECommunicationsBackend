package com.a2e.chatbot.User.service;

import com.a2e.chatbot.User.Repository.IUserService;
import com.a2e.chatbot.User.Repository.UserRepository;
import com.a2e.chatbot.User.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tejaswini.a on 20/04/20.
 */
@Service("userService")
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll(){
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User save(HashMap<String, Object> attributes){
        ObjectMapper mapper= new ObjectMapper();
        User user = mapper.convertValue(attributes, User.class);
        return userRepository.save(user);
    }

    @Override
    public void save (User user){
        userRepository.save(user);
    }

    @Override
    public User findById(long id){
        try {
            return userRepository.findById(id).get();
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void deleteUserById(long id){
        try {
            userRepository.deleteById(id);
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public  List<User> findByFirstName(String firstName){
        try{
            return userRepository.findByFirstName(firstName);
        }catch (Exception e){
            System.out.println(e);
        }
        return new ArrayList<>();
    }

    @Override
    public List<User> findByEmail(String email) {
        try{
            return userRepository.findByEmail(email);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

}
