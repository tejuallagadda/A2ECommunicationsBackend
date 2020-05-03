package com.a2e.collaboration.signup.service;

import com.a2e.collaboration.general.service.AuthService;
import com.a2e.collaboration.signup.model.SignupServiceResponse;
import com.a2e.collaboration.signup.model.SignupRequest;
import com.a2e.collaboration.user.Request.User;
import com.a2e.collaboration.user.model.UserDTO;
import com.a2e.collaboration.user.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by tejaswini.a on 03/05/20.
 */

@Service("signupService")
public class SignupService {

    Logger logger = LogManager.getLogger(SignupService.class);

    @Resource(name = "authService")
    private AuthService authService;

    private SignupServiceResponse returnObject = new SignupServiceResponse();

    @Autowired
    private UserRepository userRepository;

    //TODO use autowire instead of new to create an object
    //TODO create validation error method seperately
    //TODO add new layer for validation
    public SignupServiceResponse saveProspectUser(SignupRequest signupRequest){
        logger.info("Inside SignupService saveProspectUser() : "+signupRequest.toString());
        if(authService.isAppAuthorized(signupRequest.getCallerInfo())) {
            if (signupRequest.getUser() == null || signupRequest.getUser().getEmail() == null)
                return new SignupServiceResponse(114);
            if (signupRequest.getUser().getFirstName() == null) return new SignupServiceResponse(106);
            if (signupRequest.getUser().getLastName() == null) return new SignupServiceResponse(108);

            UserDTO user = saveNewProspectUser(signupRequest.getUser());
            logger.info("Inside LoginService validationCode() created User :" + user);
            //TODO sending email with otp
            return new SignupServiceResponse(105, user);
        }

        return new SignupServiceResponse(114);
    }

    //TODO check domain,model and value objects
    //TODO check mapping one object to other
    private UserDTO saveNewProspectUser(User user){
        logger.info("Inside SignupService saveNewProspectUser () user : "+user.toString());
        UserDTO newUser = new UserDTO();
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        Calendar date = Calendar.getInstance();
        newUser.setCreatedOn(date.getTime());
        newUser.setIsAactive(true);
        newUser.setIsProspect(true);
        newUser.setUpdatedOn(date.getTime());
        Random random = new Random();
        String id = String.format("%06d", random.nextInt(1000000));
        newUser.setUniqueCode(id);
        date.add(Calendar.MINUTE, 15);
        newUser.setUniqueCodeExpiration(date.getTime());
        userRepository.save(newUser);
        logger.info("Inside SignupService saveNewProspectUser () newuser : "+newUser.toString());
        return newUser;
    }

    public SignupServiceResponse verifyOtp(SignupRequest signupRequest){
        logger.info("Inside SignupService verifyOtp() : "+signupRequest.toString());
        if(!authService.isAppAuthorized(signupRequest.getCallerInfo())){return new SignupServiceResponse(114);}
        if(signupRequest.getUser() == null || signupRequest.getUser().getEmail() == null){return new SignupServiceResponse(106);}
        List<UserDTO> users = userRepository.findByEmail(signupRequest.getUser().getEmail());
        if(users.get(0)!=null){
            UserDTO user = users.get(0);
            if(user.getUniqueCode().equals(signupRequest.getUser().getSecret().getOtp())){
                Calendar date =Calendar.getInstance();
                if(user.getUniqueCodeExpiration().before(date.getTime())){
                    returnObject.setRespCode(102);
                    returnObject.setUser(user);
                }
                return new SignupServiceResponse(110);
            }
            else{
                return new SignupServiceResponse(109);
            }
        }
        return new SignupServiceResponse(115);
    }

    public SignupServiceResponse savePassword (SignupRequest signupRequest){
        logger.info("Inside SignupService savePassword() : "+signupRequest.toString());
        if(!authService.isAppAuthorized(signupRequest.getCallerInfo())){return new SignupServiceResponse(114);}
        if(signupRequest.getUser() == null || signupRequest.getUser().getEmail() == null){return new SignupServiceResponse(106);}
        List<UserDTO> users = userRepository.findByEmail(signupRequest.getUser().getEmail());
        if(users.get(0)!=null) {
            UserDTO user = users.get(0);
            user.setPassword(signupRequest.getUser().getSecret().getPassword());
            user.setIsProspect(false);
            user.setUpdatedOn(new Date());
            userRepository.save(user);
            returnObject.setUser(user);
            return new SignupServiceResponse(103);
        }
        return new SignupServiceResponse(115);
    }
}
