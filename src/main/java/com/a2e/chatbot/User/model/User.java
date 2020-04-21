package com.a2e.chatbot.User.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
    private String whatsapp;
    private String slack;
    private Boolean active;
    private Boolean prospect;
    private Integer unique_code;
    private Date uniqueCodeExpiration;
    private String attributes;
    private Date updatedOn;
    private Date lastLogin;
    private Date CreatedOn;
}
