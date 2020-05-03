package com.a2e.collaboration.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tejaswini.a on 20/04/20.
 */

@Repository
public interface UserRepository extends JpaRepository<UserDTO,Long>{


    List<UserDTO> findByFirstName(String FirstName);

    List<UserDTO> findByEmail(String email);


}
