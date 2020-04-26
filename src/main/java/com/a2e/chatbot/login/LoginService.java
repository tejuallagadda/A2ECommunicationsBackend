package com.a2e.chatbot.login;

import com.a2e.chatbot.User.Repository.IUserService;
import com.a2e.chatbot.User.model.User;
import com.a2e.chatbot.general.Response;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tejaswini.a on 26/04/20.
 */
@Service("loginService")
public class LoginService {

    @Autowired
    private IUserService userService;

    public Response verifyLogin(String email, String password){
        Response response = new Response();
        List<User> users = userService.findByEmail(email);
        if(users.get(0).getPassword().equals(password)){
            User user = users.get(0);
            Date date = new Date();
            user.setLastLogin(date);
            userService.save(user);
            response.setRespCode(200);
            response.setRespMessage("User successfully logged in");
            return response;
        }
        response.setRespMessage("User access denied");
        return response;
    }
}
