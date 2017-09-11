package com.barbershop.validator.subcategoryUpdateValidator;

import com.barbershop.dao.SubcategoryDao;
import com.barbershop.entity.Subcategory;
import com.barbershop.validator.Validator;
import com.barbershop.validator.subcategoryValidator.SubcategoryException;
import com.barbershop.validator.subcategoryValidator.SubcategoryValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pavelsavchenko on 05.07.17.
 */
@Component
public class SubcategoryUpdateValidator implements Validator {
    @Autowired
    private SubcategoryDao subcategoryDao;

    @Override
    public void validate(Object o) throws Exception {

        Subcategory subcategory = (Subcategory) o;

        if(subcategory.getNameOfSubcategory().isEmpty()){
            throw new SubcategoryException(SubcategoryUpdateValidatorMessages.SUBCATEGORY_EMPTY_FIELD);
        }
        else if(subcategoryDao.findByNameOfSubcategory(subcategory.getNameOfSubcategory()) !=null)
        {
            throw  new SubcategoryException(SubcategoryUpdateValidatorMessages.SUBCATEGORY_ALREADY_EXIST);
        }
    }

}
