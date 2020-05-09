package com.a2e.collaboration.controllers.request;

import com.a2e.collaboration.controllers.commons.UserDTO;
import lombok.*;

/**
 * Created by tejaswini.a on 02/05/20.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest extends A2ERequest {
    private UserDTO user;
}
