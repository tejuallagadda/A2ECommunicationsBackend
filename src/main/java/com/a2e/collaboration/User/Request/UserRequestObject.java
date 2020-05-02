package com.a2e.collaboration.user.Request;

import com.a2e.collaboration.login.loginVO.Secret;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestObject {
    private String email;
    private String firstName;
    private String lastname;
    private Secret secret;
}
