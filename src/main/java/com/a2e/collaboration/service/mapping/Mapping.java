package com.a2e.collaboration.service.mapping;

import com.a2e.collaboration.controllers.commons.UserDTO;
import com.a2e.collaboration.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class Mapping {

    public void mapUser(UserDTO userDTO, User user){
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
    }
}
