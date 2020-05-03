package com.a2e.collaboration.controllers.commons;

import com.a2e.collaboration.commons.Secret;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//TODO use same for request and response
public class User {
    private String email;
    private Boolean isProspect;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private Secret secret;
}
