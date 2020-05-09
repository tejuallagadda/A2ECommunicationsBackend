package com.a2e.collaboration.service.validation;

import com.a2e.collaboration.commons.Secret;
import com.a2e.collaboration.commons.Utilities;
import org.springframework.beans.factory.annotation.Autowired;

import static com.a2e.collaboration.commons.A2EErrorCode.*;

// Do not add any instance variables which are not autowired to this class.
public class UserValidation {
    @Autowired
    private SecretValidation secretValidation;

    public UserValidation isValidEmail(String email) throws ValidationException {
        //TODO keep valid email logic here.
        if(Utilities.isValidEmail(email))
            return this;
        else
            throw new ValidationException(INVALID_EMAIL);
    }
    public UserValidation isValidFirstName(String name) throws ValidationException {
        if(Utilities.isValidFirstName(name))
            return this;
        else
            throw new ValidationException(INVALID_FIRST_NAME);

    }
    public UserValidation isValidLastName(String name) throws ValidationException {
        if(Utilities.isValidLastName(name))
            return this;
        else
            throw new ValidationException(INVALID_LAST_NAME);

    }

    public UserValidation isValidOTP(Secret secret) throws ValidationException {
        if(Utilities.isNull(secret))
            throw new ValidationException(INVALID_SECRET);
        else
            secretValidation.isValidOTP(secret.getOtp());
        return this;
    }

    public UserValidation isValidPassword(Secret secret) throws ValidationException {
        if(Utilities.isNull(secret))
            throw new ValidationException(INVALID_SECRET);
        else
            secretValidation.isValidPassword(secret.getPassword());
        return this;

    }
}
