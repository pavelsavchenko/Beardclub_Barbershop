package com.barbershop.validator.commodityValidator;

import com.barbershop.dao.CommodityDao;
import com.barbershop.entity.Commodity;
import com.barbershop.validator.Validator;
import com.barbershop.validator.servicesOfBarberValidator.ServiceOfBarberException;
import com.barbershop.validator.servicesOfBarberValidator.ServicesOfBarberValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;

/**
 * Created by pavelsavchenko on 02.06.17.
 */
@Component
public class CommodityValidator implements Validator {

    @Autowired
    private CommodityDao commodityDao;

    @Override
    public void validate(Object o) throws Exception {

        Commodity commodity = (Commodity) o;

        if(commodity.getNameOfCommodity().isEmpty()){
            throw  new CommodityException(CommodityValidatorMessage.COMMODITY_EMPTY_FIELD);
        }else if(commodityDao.findByNameOfCommodity(commodity.getNameOfCommodity()) !=null){
            throw new CommodityException(CommodityValidatorMessage.COMMODITY_NAME_ALREADY_EXIST);
        }else if(commodity.getPrice().isEmpty()){
            throw new CommodityException(CommodityValidatorMessage.PRICE_EMPTY_FIELD);
        }else if(commodity.getPrice().matches(".*[a-zA-Zа-яА-Я].*") ||
                Integer.parseInt(commodity.getPrice())<=0){
            throw new CommodityException(CommodityValidatorMessage.WRONG_CHARACTER);
        } else  if(commodity.getDesription().isEmpty()){
            throw  new CommodityException(CommodityValidatorMessage.DESCRIPTION_EMPTY_FIELD);
        }


    }
}
