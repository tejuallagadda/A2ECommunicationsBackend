package com.a2e.collaboration.service.validation;

import com.a2e.collaboration.commons.Utilities;
import com.a2e.collaboration.controllers.commons.UserDTO;
import com.a2e.collaboration.controllers.request.UserRequest;
import com.a2e.collaboration.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.a2e.collaboration.commons.A2EErrorCode.*;

@Service
public class Validation {

    @Autowired
    private UserValidation userValidation;

    public void validateSignUpPage(UserRequest userRequest) throws ValidationException {

        UserDTO user = userRequest.getUser();
        if(Utilities.isNull(user))
            throw new ValidationException(INVALID_USER);
        userValidation.isValidEmail(user.getEmail())
                .isValidFirstName(user.getFirstName())
                .isValidLastName(user.getLastName())
                .isNotExistingEmail(user.getEmail());
    }
    public void validateOTPPage(UserRequest userRequest) throws ValidationException {
        UserDTO user = userRequest.getUser();
        if (Utilities.isNull(user))
            throw new ValidationException(INVALID_USER);
        userValidation.isValidEmail(user.getEmail()).isValidOTP(user.getSecret());
    }

    public void validateSavePasswordPage(UserRequest userRequest) throws ValidationException {
        UserDTO user = userRequest.getUser();
        if (Utilities.isNull(user))
            throw new ValidationException(INVALID_USER);
        userValidation.isValidEmail(user.getEmail()).isValidPassword(user.getSecret());
    }

    //TODO ValidateSavePassword and ValidateLoginpage are same
    public void validateLoginPage(UserRequest userRequest) throws ValidationException {
        UserDTO user = userRequest.getUser();
        if (Utilities.isNull(user))
            throw new ValidationException(INVALID_USER);
        userValidation.isValidEmail(user.getEmail()).isValidPassword(user.getSecret());
    }
}
