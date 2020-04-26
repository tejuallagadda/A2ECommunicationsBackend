package com.a2e.chatbot.controller;

import com.a2e.chatbot.login.LoginService;
import com.a2e.chatbot.general.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by tejaswini.a on 26/04/20.
 */

@Controller
public class LoginController {

    @Resource(name = "loginService")
    private LoginService loginService;

    @GetMapping("/login")
    public @ResponseBody Response verifyLogin(@RequestParam("email") String email, @RequestParam("password") String password){
        return loginService.verifyLogin(email,password);
    }
}
