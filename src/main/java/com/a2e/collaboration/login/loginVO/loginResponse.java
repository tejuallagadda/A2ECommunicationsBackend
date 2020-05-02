package com.a2e.collaboration.login.loginVO;

import com.a2e.collaboration.general.response.A2eResponse;
import com.a2e.collaboration.login.loginVO.RespDetails;
import com.a2e.collaboration.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private A2eResponse finalResp;
    private RespDetails details;

    public LoginResponse(long respCode, long subRespCode, String respMsg){
        this.finalResp = new A2eResponse(respCode, subRespCode, respMsg);
    }
    public LoginResponse(long respCode, long subRespCode, String respMsg, User user){
        this.finalResp = new A2eResponse(respCode,subRespCode,respMsg);
        this.details = new RespDetails(user);
    }
}
