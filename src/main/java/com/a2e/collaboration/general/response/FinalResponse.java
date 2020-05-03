package com.a2e.collaboration.general.response;

import com.a2e.collaboration.login.loginVO.RespDetails;
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
//TODO extend A2EResponse
public class FinalResponse {
    private A2eResponse finalResp;
    private RespDetails details;

    public FinalResponse(long respCode, long subRespCode, String respMsg){
        this.finalResp = new A2eResponse(respCode, subRespCode, respMsg);
    }
    public FinalResponse(long respCode, long subRespCode, String respMsg, UserDTO user){
        this.finalResp = new A2eResponse(respCode,subRespCode,respMsg);
        this.details = new RespDetails(user);
    }
}
