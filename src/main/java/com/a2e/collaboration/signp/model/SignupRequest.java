package com.a2e.collaboration.signp.model;

import com.a2e.collaboration.general.request.A2eRequest;
import com.a2e.collaboration.user.Request.UserRequestObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    private A2eRequest callerInfo;
    private UserRequestObject user;
}
