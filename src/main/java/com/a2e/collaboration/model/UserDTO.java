package com.a2e.collaboration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tejaswini.a on 20/04/20.
 */
@Entity
@Table(name = "users_info")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "SEQ_GEN")
    private long id;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @NonNull
    @Column(name = "email", unique = true)
    private String email;

    @Column(name  = "phone")
    private String phone;

    @Column(name = "whatsapp")
    private String whatsapp;

    @Column(name = "slack")
    private String slack;

    @Column(name = "active")
    private Boolean isAactive;

    @Column(name = "prospect")
    private Boolean isProspect;

    @JsonIgnore
    @Column(name = "unique_code")
    private String uniqueCode;

    @Column(name = "unique_code_Expiration")
    private Date uniqueCodeExpiration;

    @JsonIgnore
    @Column(name = "attributes")
    private String attributes;

    @NonNull
    @Column(name = "updated_on")
    private Date updatedOn;

    @NonNull
    @Column(name = "last_login")
    private Date lastLogin;

    @NonNull
    @Column(name = "created_on")
    private Date createdOn;
}
