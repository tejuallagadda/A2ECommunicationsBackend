package com.a2e.collaboration.controllers.response;

import com.a2e.collaboration.controllers.commons.User;
import lombok.*;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//TODO extend A2EResponse
public class UserResponse extends A2EResponse{
    private User user;

/*    public UserResponse(long respCode, long subRespCode, String respMsg){
        this.finalResp = new A2EResponse(respCode, subRespCode, respMsg);
    }
    public UserResponse(long respCode, long subRespCode, String respMsg, UserDTO user){
        this.finalResp = new A2EResponse(respCode,subRespCode,respMsg);
        this.details = new RespDetails(user);
    }

 */
}
