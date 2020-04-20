package com.a2e.chatbot.User.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tejaswini.a on 20/04/20.
 */
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
    private String whatsapp;
    private String slack;
    private Boolean active;
    private Boolean prospect;
    private String unique_code;
    private Date uniqueCodeExpiration;
    private String attributes;
    private Date updatedOn;
    private Date lastLogin;
    private Date CreatedOn;
}
