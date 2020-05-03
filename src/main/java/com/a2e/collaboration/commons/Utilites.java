package com.a2e.collaboration.commons;

import org.springframework.context.annotation.Bean;


public class Utilites {


    public static boolean isNull(Object o){
        return null == o;
    }
    public static boolean isNotNull(Object o){
        return null != o;
    }
    public boolean isValidEmail(String email){
        //TODO keep valid email logic here.
        return true;
    }
}
