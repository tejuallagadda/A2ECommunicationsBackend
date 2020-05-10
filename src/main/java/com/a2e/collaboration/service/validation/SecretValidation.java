package com.a2e.collaboration.service.validation;

import org.springframework.stereotype.Service;

import static com.a2e.collaboration.commons.A2EErrorCode.*;

@Service
public class SecretValidation {

    public SecretValidation isValidOTP(String otp) throws ValidationException {
        //TODO keep valid email logic here.
        if(otp.length() == 0)
            throw new ValidationException(EMPTY_OTP);
        else
            return this;
    }
    public SecretValidation isValidPassword(String password) throws ValidationException {
        //TODO keep valid email logic here.
        if(password.length() == 0)
            throw new ValidationException(EMPTY_PASSWORD);
        else
            return this;
    }
}
