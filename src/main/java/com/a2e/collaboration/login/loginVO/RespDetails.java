package com.a2e.collaboration.login.loginVO;

import com.a2e.collaboration.user.model.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespDetails {
    private UserDTO user;
}
