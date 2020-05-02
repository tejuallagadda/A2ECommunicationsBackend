package com.a2e.collaboration.user.repository;

import com.a2e.collaboration.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
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
