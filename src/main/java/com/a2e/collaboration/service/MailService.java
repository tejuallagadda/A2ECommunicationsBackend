package com.a2e.collaboration.service;

import com.a2e.collaboration.commons.A2EErrorCode;
import com.a2e.collaboration.service.validation.ServiceException;
import com.a2e.collaboration.service.validation.ValidationException;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;

/**
 * Created by tejaswini.a on 10/05/20.
 */
@Service
public class MailService {

    Logger logger = LogManager.getLogger(MailService.class);

    public void sendMailWithOTP(String emailId, String OTP){
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("a2ecollaboration2020@gmail.com", "nkvwwpdolqtezeaw"));
            email.setSSLOnConnect(true);
            email.setFrom("a2ecollaboration2020@gmail.com");
            email.setSubject("OTP to register in A2E");
            email.setMsg("OTP requested by you is " + OTP + "\n This message is computer generated. Please do not reply");
            email.addTo(emailId);
            email.send();
        } catch(Exception e){
            logger.error("Could not send OTP to the mail address", e);
        }
        //TODO throw exception if mail not sent
    }

}
