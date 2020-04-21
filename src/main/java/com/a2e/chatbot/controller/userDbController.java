package com.a2e.chatbot.controller;

import com.a2e.chatbot.User.Repository.IUserService;
import com.a2e.chatbot.User.model.User;
import com.a2e.chatbot.User.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tejaswini.a on 20/04/20.
 */
@Controller
public class userDbController {

    @Autowired
    private IUserService userService;

    @GetMapping("/allUsers")
    public @ResponseBody List<User> findUsers(Model model){
        return  (List<User>) userService.findAll();
    }


    @PostMapping("/addUser")
    public @ResponseBody User addUser( @RequestBody String body){
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        try {
            HashMap<String, Object> attributes = mapper.readValue(body, HashMap.class);
            return userService.save(attributes);
        }catch (Exception e){
            System.out.print(e);
        }

        return user;
    }

    @GetMapping("/user/{userId}")
    public @ResponseBody User getUserById(@PathVariable("userId") long id){
        try {
            return userService.findById(id);
        } catch (Exception e){
            throw new IllegalArgumentException("User with ID is not available");
        }
    }

    @DeleteMapping("user/{userId}")
    public @ResponseBody void deleteUserById(@PathVariable("userId") long id){
        userService.deleteUserById(id);
    }

}
