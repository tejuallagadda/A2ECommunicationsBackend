package com.a2e.collaboration.commons;

import lombok.Getter;

@Getter
public enum A2EErrorCode {

    INVALID_USER(400, 1001, "User invalid", "Some attribute in the user is not valid"),
    INVALID_EMAIL(400, 1002, "Invalid email", "Email is not according to standard email format"),
    INVALID_FIRST_NAME(400, 1003, "Invalid First Name", "Name might be empty or small"),
    INVALID_LAST_NAME(400, 1004, "Invalid Last Name", "Name might be empty or small"),
    INVALID_SECRET(400, 1005, "Secret info not present", ""),
    EMPTY_OTP(400, 1006, "OTP is empty", ""),
    EMPTY_PASSWORD(400, 1007, "password is empty", ""),
    INVALID_OTP(401, 1008, "OTP is Invalid", ""),
    INVALID_PASSWORD(401, 1009, "password is invalid", ""),
    OTP_EXPIRED(401, 1010, "OTP Expired", ""),
    USER_NOT_FOUND(404, 1011, "User not found", ""),
    EMAIL_ALREADY_EXISTS(400, 1012, "Email already exists", ""),
    EMAIL_NOT_SENT(502, 1013, "Email not sent", "Email could not be sent due to some internal error"),
    APP_NOT_AUTHORIZED(401,8000, "Unauthorized App", "Calling Application is not authorized with the given key");

    private int httpCode;
    private int a2eCode;
    private String message;
    private String description;

    A2EErrorCode(int httpCode, int a2eCode, String message, String description){
        this.httpCode = httpCode;
        this.a2eCode = a2eCode;
        this.message = message;
        this.description = description;
    }


}
