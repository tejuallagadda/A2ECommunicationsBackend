package com.a2e.collaboration.controllers.request.commons;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CallerInfo {

    private String appName;
    private String appKey;
}
