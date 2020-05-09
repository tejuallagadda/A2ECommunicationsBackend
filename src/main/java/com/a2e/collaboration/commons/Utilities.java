package com.a2e.collaboration.commons;

import org.springframework.context.annotation.Bean;


public class Utilities {


    public static boolean isNull(Object o){
        return null == o;
    }
    public static boolean isNotNull(Object o){
        return null != o;
    }
    public static boolean isValidEmail(String email){
        //TODO keep valid email logic here.
        return true;
    }
    public static boolean isValidFirstName(String Name){
        //TODO implement
        return true;
    }
    public static boolean isValidLastName(String name){
        //TODO implement
        return true;
    }
}
