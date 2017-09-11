package com.barbershop.validator.userUpdateValidator;

import com.barbershop.entity.User;
import com.barbershop.validator.Validator;
import com.barbershop.validator.userValidator.UserException;
import com.barbershop.validator.userValidator.UserValidatorMessages;
import org.springframework.stereotype.Component;

/**
 * Created by pavelsavchenko on 03.07.17.
 */
@Component
public class UserUpdateValidator implements Validator {

    @Override
    public void validate(Object o) throws Exception {

        User user = (User)o;

        if(user.getName().isEmpty()){
            throw new UserException(UserUpdateValidatorMessages.EMPTY_USERNAME_FIELD);
        }else if(user.getPhoneNumber().isEmpty()){
            throw new UserException(UserUpdateValidatorMessages.EMPTY_PHONE_NUMBER_FIELD);
        }else if(user.getPhoneNumber().length()!= 10) {
            throw new UserException(UserValidatorMessages.PHONE_LENGTH);
        }
    }
}
