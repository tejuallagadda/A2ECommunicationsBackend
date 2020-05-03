package com.a2e.collaboration.controllers.response;

/**
 * Created by tejaswini.a on 03/05/20.
 */
public enum ResponseEnums {

    EMAIL_SENT(200, 101, "Email with OTP sent successfully");


    private final long respCode;
    private final long subRespcode;
    private final String respMsg;

    private ResponseEnums(long respCode, long subRespcode, String respMsg){
        this.respCode = respCode;
        this.subRespcode = subRespcode;
        this.respMsg = respMsg;
    }

}
