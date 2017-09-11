package com.barbershop.validator.servicesOfBarberValidator;

import com.barbershop.dao.BarberServiceDao;
import com.barbershop.entity.ServicesOfBarber;
import com.barbershop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pavelsavchenko on 04.06.17.
 */
@Component
public class ServiceOfBarberValidator implements Validator {

    @Autowired
    private BarberServiceDao barberServiceDao;

    @Override
    public void validate(Object o) throws Exception {

        ServicesOfBarber servicesOfBarber = (ServicesOfBarber) o;

        if(servicesOfBarber.getNameOfBarberService().isEmpty()){
            throw new ServiceOfBarberException(ServicesOfBarberValidatorMessages.SERVICE_FIELD_EMPTY);
        }else if(barberServiceDao.findByNameOfBarberService(servicesOfBarber.getNameOfBarberService())!=null){
            throw new ServiceOfBarberException(ServicesOfBarberValidatorMessages.SERVICE_OF_BARBER_ALREADY_EXIST);
        }else if(servicesOfBarber.getPrice().isEmpty()){
            throw new ServiceOfBarberException(ServicesOfBarberValidatorMessages.PRICE_FIELD_EMPTY);
        }else if(servicesOfBarber.getPrice().matches(".*[a-zA-Zа-яА-Я].*") ||
                Integer.parseInt(servicesOfBarber.getPrice())<=0){
           throw new ServiceOfBarberException(ServicesOfBarberValidatorMessages.WRONG_CHARACKTER);
        }
    }
}
