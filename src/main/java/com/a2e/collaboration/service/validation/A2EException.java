package com.a2e.collaboration.service.validation;

import com.a2e.collaboration.commons.A2EErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class A2EException extends Exception {
    private A2EErrorCode a2EErrorCode;

    public A2EException(A2EErrorCode a2EErrorCode){
        this.a2EErrorCode = a2EErrorCode;
    }
}

