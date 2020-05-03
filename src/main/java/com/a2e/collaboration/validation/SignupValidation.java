package com.a2e.collaboration.validation;

import com.a2e.collaboration.commons.Utilites;
import com.a2e.collaboration.controllers.commons.User;
import com.a2e.collaboration.controllers.request.UserRequest;
import com.a2e.collaboration.controllers.response.UserResponse;

import javax.swing.text.Utilities;

public class SignupValidation {

    public boolean signupPageValidation(UserRequest userRequest, UserResponse userResponse){
        User user = userRequest.getUser();
        if (Utilites.isNull(user))
            userResponse.setError(INVALID_USER);
        else if (!Utilites.isValidEmail(user.getEmail()))
            userResponse.setError(INVALID_EMAIL);
        else if (!Utilites.isValidName(user.getFirstName) || Utilities.isValidName(user.getLastName()))
            userResponse.setError(INVALID_FIRST_OR_LAST_NAME);
        else return true;
        return false;
    }
    public boolean secretPageValidation(UserRequest userRequest, UserResponse userResponse){
        User user = userRequest.getUser();
        if (Utilites.isNull(user))
            userResponse.setError(INVALID_USER);
        else if (!Utilites.isValidEmail(user.getEmail()))
            userResponse.setError(INVALID_EMAIL);
        else
            return true;
        return false;
    }
}
