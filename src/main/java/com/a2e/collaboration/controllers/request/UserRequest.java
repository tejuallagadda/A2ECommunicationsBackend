package com.a2e.collaboration.controllers.request;

import com.a2e.collaboration.controllers.commons.User;
import lombok.*;

/**
 * Created by tejaswini.a on 02/05/20.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest extends A2ERequest {
    private User user;
}
