package com.a2e.collaboration.service.validation;

import com.a2e.collaboration.commons.A2EErrorCode;

public class ValidationException extends A2EException{
    public ValidationException(A2EErrorCode a2EErrorCode) {
        super(a2EErrorCode);
    }
}
