package com.barbershop.validator.userValidator;

import com.barbershop.dao.UserDao;
import com.barbershop.entity.User;
import com.barbershop.validator.Validator;
import com.barbershop.validator.servicesOfBarberValidator.ServiceOfBarberException;
import com.barbershop.validator.servicesOfBarberValidator.ServicesOfBarberValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pavelsavchenko on 29.05.17.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Override
    public void validate(Object o) throws Exception {

        User user = (User) o;

        if(user.getName().isEmpty()){
            throw new UserException(UserValidatorMessages.EMPTY_USERNAME_FIELD);
        }else if(userDao.findByName(user.getName()) !=null) {
            throw new UserException(UserValidatorMessages.USERNAME_ALREADY_EXIST);
        }else if(user.getPhoneNumber().isEmpty()){
            throw  new UserException(UserValidatorMessages.EMPTY_PHONE_NUMBER_FIELD);
        }else if(user.getPhoneNumber().length()!= 10){
            throw new UserException(UserValidatorMessages.PHONE_LENGTH);
        } else if(user.getPhoneNumber().matches(".*[a-z].*")){
            throw new UserException(UserValidatorMessages.WRONG_CHARACTER);
        }else if(user.getEmail().isEmpty()){
            throw  new UserException(UserValidatorMessages.EMPTY_EMAIL_FIELD);
        }else if(!user.getEmail().contains("@")){
            throw  new UserException(UserValidatorMessages.MISSING_CHARACTER);
        }else if(userDao.findByEmail(user.getEmail()) !=null){
            throw new UserException(UserValidatorMessages.EMAIL_ALREADY_EXIST);
        }else if(user.getPassword().isEmpty()){
            throw  new UserException(UserValidatorMessages.EMPTY_PASSWORD_FIELD);
        }else if(user.getPassword().length()<=3){
            throw  new UserException(UserValidatorMessages.INVALID_LENGTH);
        }

    }
}
