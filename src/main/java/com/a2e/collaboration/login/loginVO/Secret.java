package com.a2e.collaboration.login.loginVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tejaswini.a on 02/05/20.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Secret {
    private String otp;
    private String password;

    @Override
    public String toString(){
        return "******";
    }

    public Boolean equals(Secret secret){
        if((secret.otp!=null && secret.otp == this.otp)||
                (secret.password!=null && secret.password == this.password)){
            return true;
        }
        return false;
    }
}
