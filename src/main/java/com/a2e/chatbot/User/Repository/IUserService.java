package com.a2e.chatbot.User.Repository;

import com.a2e.chatbot.User.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by tejaswini.a on 20/04/20.
 */
public interface IUserService {
    List<User> findAll();

    void save(User user);

    User save(HashMap<String, Object> attributes);

    User findById(long id);

    void deleteUserById(long id);

    List<User> findByFirstName(String FirstName);

    List<User> findByEmail(String email);

}
