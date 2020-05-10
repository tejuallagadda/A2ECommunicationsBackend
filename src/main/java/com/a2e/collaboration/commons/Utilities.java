package com.a2e.collaboration.commons;

import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.regex.Pattern;


public class Utilities {


    public static boolean isNull(Object o){
        return null == o;
    }
    public static boolean isNotNull(Object o){
        return null != o;
    }
    public static boolean isValidEmail(String email){
        if(isNull(email) || email.isEmpty()) { return false; }

        String emailRegex =  "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
    public static boolean isValidString(String name){
        return isNotNull(name) && !name.isEmpty() && name.matches("^[a-zA-Z]*$");
    }

    public static String getOTP(){
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }
}
