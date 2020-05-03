package com.a2e.collaboration.signup.model;

import com.a2e.collaboration.user.model.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tejaswini.a on 03/05/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupServiceResponse {
    private long respCode;
    private UserDTO user;

    public SignupServiceResponse(long code){
        this.respCode = code;
    }
}
