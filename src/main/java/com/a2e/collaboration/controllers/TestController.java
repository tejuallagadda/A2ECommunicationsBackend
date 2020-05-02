package com.a2e.collaboration.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@RestController
public class TestController {

    @GetMapping(value="/")
    public String test(){
        return "Welcome";
    }

}
