package com.a2e.collaboration.controllers.response;

import com.a2e.collaboration.commons.A2EErrorCode;
import com.a2e.collaboration.controllers.response.commons.A2EHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class A2EResponse {
    private static final int SUCCESS_CODE = 200;
    private static final int SUCCESS_A2E_CODE = 0;
    private A2EHeader a2EHeader = new A2EHeader();
    public void setError(A2EErrorCode a2EErrorCode){
        a2EHeader.setCode(a2EErrorCode.getHttpCode());
        a2EHeader.setSubCode(a2EErrorCode.getA2eCode());
        a2EHeader.setMessage(a2EErrorCode.getMessage());
    }
    public void setSuccess(){
        a2EHeader.setCode(SUCCESS_CODE);
        a2EHeader.setSubCode(SUCCESS_A2E_CODE);
    }
}
