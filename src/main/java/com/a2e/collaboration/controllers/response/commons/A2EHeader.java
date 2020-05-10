package com.a2e.collaboration.controllers.response.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class A2EHeader {
    private long code;
    private long subCode;
    private String message;
}
