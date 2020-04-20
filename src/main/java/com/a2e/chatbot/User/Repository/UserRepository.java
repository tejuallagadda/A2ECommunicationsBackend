package com.a2e.chatbot.User.Repository;

import com.a2e.chatbot.User.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tejaswini.a on 20/04/20.
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
