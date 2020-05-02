package com.a2e.collaboration.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseObject {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String whatsapp;
    private String slack;
    private Boolean isActive;
    private Boolean isProspect;
    private Date uniqueCodeExpiration;
    private Date updatedOn;
    private Date lastLogin;
    private Date createdOn;
}
