package com.barbershop.validator.commodityUpdateValidator;

import com.barbershop.dao.CommodityDao;
import com.barbershop.entity.Commodity;
import com.barbershop.validator.Validator;
import com.barbershop.validator.commodityValidator.CommodityException;
import com.barbershop.validator.commodityValidator.CommodityValidatorMessage;
import com.barbershop.validator.servicesOfBarberValidator.ServiceOfBarberException;
import com.barbershop.validator.servicesOfBarberValidator.ServicesOfBarberValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pavelsavchenko on 11.07.17.
 */
@Component
public class CommodityUpdateValidator implements Validator {

    @Autowired
    private CommodityDao commodityDao;

    @Override
    public void validate(Object o) throws Exception {

        Commodity commodity = (Commodity) o;

        if(commodity.getNameOfCommodity().isEmpty()){
            throw  new CommodityException(CommodityUpdateValidatorMessages.COMMODITY_EMPTY_FIELD);
        }else if(commodityDao.findByNameOfCommodity(commodity.getNameOfCommodity()) !=null){
            throw new CommodityException(CommodityUpdateValidatorMessages.COMMODITY_NAME_ALREADY_EXIST);
        }else if(commodity.getPrice().isEmpty()){
            throw new CommodityException(CommodityUpdateValidatorMessages.PRICE_EMPTY_FIELD);
        }else if(commodity.getPrice().matches(".*[a-zA-Zа-яА-Я].*") ||
                Integer.parseInt(commodity.getPrice())<=0){
            throw new CommodityException(CommodityUpdateValidatorMessages.WRONG_CHARACTER);
        } else  if(commodity.getDesription().isEmpty()){
            throw  new CommodityException(CommodityValidatorMessage.DESCRIPTION_EMPTY_FIELD);
        }

    }
}
