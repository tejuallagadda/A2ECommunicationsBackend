package com.a2e.chatbot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tejaswini.a on 20/04/20.
 */
@RestController
public class TestController {
    @GetMapping("/")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("Welcome");
    }
}
