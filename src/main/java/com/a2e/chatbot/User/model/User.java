package com.a2e.chatbot.User.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

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
@EnableAutoConfiguration
public class User {
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
    private Boolean active;

    @Column(name = "prospect")
    private Boolean prospect;

    @Column(name = "unique_code")
    private Integer uniqueCode;

    @Column(name = "unique_code_Expiration")
    private Date uniqueCodeExpiration;

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
