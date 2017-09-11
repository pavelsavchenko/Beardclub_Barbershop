package com.barbershop.validator.subcategoryValidator;

import com.barbershop.dao.SubcategoryDao;
import com.barbershop.entity.Subcategory;
import com.barbershop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pavelsavchenko on 31.05.17.
 */
@Component
public class SubcategoryValidator implements Validator {

    @Autowired
    private SubcategoryDao subcategoryDao;

    @Override
    public void validate(Object o) throws Exception {

        Subcategory subcategory = (Subcategory) o;

        if(subcategory.getNameOfSubcategory().isEmpty()){
            throw new SubcategoryException(SubcategoryValidatorMessages.SUBCATEGORY_EMPTY_FIELD);
            }else if(subcategoryDao.findByNameOfSubcategory(subcategory.getNameOfSubcategory()) !=null)
            {
                throw  new SubcategoryException(SubcategoryValidatorMessages.SUBCATEGORY_ALREADY_EXIST);
            }
        }

    }

