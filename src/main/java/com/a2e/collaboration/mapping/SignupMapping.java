package com.a2e.collaboration.mapping;

import com.a2e.collaboration.model.UserDTO;

public class SignupMapping {

    public void mapUser(User user, UserDTO userDTO){
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        Calendar date = Calendar.getInstance();
        userDTO.setCreatedOn(date.getTime());
        //TODO Can we hardcode true value here ?
        userDTO.setIsActive(true);
        userDTO.setIsProspect(true);
        userDTO.setUpdatedOn(date.getTime());
        Random random = new Random();
        String otp = String.format("%06d", random.nextInt(1000000));
        userDTO.setUniqueCode(otp);
        date.add(Calendar.MINUTE, 15);
        userDTO.setUniqueCodeExpiration(date.getTime());
    }
}
