package com.a2e.collaboration.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tejaswini.a on 02/05/20.
 *
 * Holds OTP or password that user has entered in his/her website or app.
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

    /* public Boolean equals(Secret secret){
        if((secret.otp!=null && secret.otp == this.otp)||
                (secret.password!=null && secret.password == this.password)){
            return true;
        }
        return false;
    }*/
    
   /*
    * @param otp User`s Actual OTP.
    * @return returns true if actual and entered otp are same
    */
    public Boolean validateOtp(String actualOtp){
        return Utilities.isNotNull(this.otp) && this.otp.equals(actualOtp);
    }

    /*
     * @param actualPassword  User`s Actual Password.
     * @return returns true if actual and entered password are same
     */
    public Boolean validatePassword(String actualpassword){
        return Utilities.isNotNull(this.password) && this.otp.equals(actualpassword);
    }
}
