package com.a2e.chatbot.controller;

import com.a2e.chatbot.User.Repository.IUserService;
import com.a2e.chatbot.User.model.User;
import com.a2e.chatbot.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by tejaswini.a on 20/04/20.
 */
@Controller
public class userDbController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public @ResponseBody List<User> findUsers(Model model){
        return  (List<User>) userService.findAll();
    }



}
