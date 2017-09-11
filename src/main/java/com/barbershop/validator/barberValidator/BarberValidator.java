package com.barbershop.validator.barberValidator;

import com.barbershop.entity.Barber;
import com.barbershop.validator.Validator;
import org.springframework.stereotype.Component;

/**
 * Created by pavelsavchenko on 02.06.17.
 */
@Component
public class BarberValidator implements Validator {

    @Override
    public void validate(Object o) throws Exception {

        Barber barber = (Barber)o;
        if(barber.getFirstName().isEmpty()){
            throw new BarberException(BarberValidatorMessage.BARBER_FIRST_NAME_FIELD_EMPTY);
        }else if(barber.getLastName().isEmpty()){
            throw  new BarberException(BarberValidatorMessage.BARBER_LAST_NAME_FIELD_EMPTY);
        }else if(barber.getPosition().isEmpty()){
            throw new BarberException(BarberValidatorMessage.JOB_FIELD_EMPTY);
        }
    }
}
