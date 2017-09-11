package com.barbershop.validator.userLoginValidator;

import com.barbershop.dao.UserDao;
import com.barbershop.entity.User;
import com.barbershop.validator.Validator;
import com.barbershop.validator.userValidator.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by pavelsavchenko on 16.06.17.
 */
@Component
public class UserLoginValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void validate(Object o) throws Exception {

        User user = (User)o;

        if(user.getName().isEmpty()){
            throw  new UserException(UserLoginValidatorMessage.EMPTY_USERNAME_FIELD);
        }else if(userDao.findByName(user.getName()) == null){
            throw new UserException(UserLoginValidatorMessage.WRONG_USERNAME_OR_PASSWORD);
        }else if(user.getPassword().isEmpty()){
            throw new UserException(UserLoginValidatorMessage.EMPTY_PASSWORD_FIELD);
        } else if(!encoder.matches(user.getPassword(),
                    userDao.findByName(user.getName()).getPassword())){
            throw new UserException(UserLoginValidatorMessage.WRONG_USERNAME_OR_PASSWORD);
        }
    }
}
