package com.a2e.collaboration.service.validation;

import com.a2e.collaboration.commons.Utilities;
import org.springframework.stereotype.Service;

import static com.a2e.collaboration.commons.A2EErrorCode.*;

@Service
public class SecretValidation {

    public SecretValidation isValidOTP(String otp) throws ValidationException {
        if(Utilities.isNull(otp))
            throw new ValidationException(INVALID_OTP);
        else if(otp.length() == 0)
            throw new ValidationException(EMPTY_OTP);
        else
            return this;
    }
    public SecretValidation isValidPassword(String password) throws ValidationException {
        if(Utilities.isNull(password))
            throw new ValidationException(INVALID_PASSWORD);
        else if(password.length() == 0)
            throw new ValidationException(EMPTY_PASSWORD);
        else
            return this;
    }
}
