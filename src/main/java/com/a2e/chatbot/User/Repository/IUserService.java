package com.a2e.chatbot.User.Repository;

import com.a2e.chatbot.User.model.User;

import java.util.List;

/**
 * Created by tejaswini.a on 20/04/20.
 */
public interface IUserService {
    List<User> findAll();
}
