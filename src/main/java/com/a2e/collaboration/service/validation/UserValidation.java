package com.a2e.collaboration.service.validation;

import com.a2e.collaboration.commons.Secret;
import com.a2e.collaboration.commons.Utilities;
import com.a2e.collaboration.model.User;
import com.a2e.collaboration.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.a2e.collaboration.commons.A2EErrorCode.*;

// Do not add any instance variables which are not autowired to this class.
@Service
public class UserValidation {
    @Autowired
    private SecretValidation secretValidation;

    @Autowired
    private UserRepository userRepository;

    public UserValidation isValidEmail(String email) throws ValidationException {
        if(Utilities.isValidEmail(email)) {
            return this;
        }
        throw new ValidationException(INVALID_EMAIL);
    }
    public UserValidation isValidFirstName(String name) throws ValidationException {
        if(Utilities.isValidString(name))
            return this;
        else
            throw new ValidationException(INVALID_FIRST_NAME);

    }
    public UserValidation isValidLastName(String name) throws ValidationException {
        if(Utilities.isValidString(name))
            return this;
        else
            throw new ValidationException(INVALID_LAST_NAME);

    }
    public UserValidation isNotExistingEmail(String name) throws ValidationException {
        List<User> users = userRepository.findByEmail(name);
        if(users.size()>0){
            throw new ValidationException(EMAIL_ALREADY_EXISTS);
        }
        return this;
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
