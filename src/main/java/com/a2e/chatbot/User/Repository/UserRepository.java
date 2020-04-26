package com.a2e.chatbot.User.Repository;

import com.a2e.chatbot.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tejaswini.a on 20/04/20.
 */

@Repository
public interface UserRepository extends JpaRepository<User,Long>{


    List<User> findByFirstName(String FirstName);

    List<User> findByEmail(String email);


}
