package com.barbershop.validator.categoryOfCommodityValidator;

import com.barbershop.dao.CategoryOfCommodityDao;
import com.barbershop.entity.CategoryOfCommodity;
import com.barbershop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pavelsavchenko on 31.05.17.
 */
@Component
public class CategoryOfCommodityValidator implements Validator {

    @Autowired
    private CategoryOfCommodityDao categoryOfCommodityDao;

    @Override
    public void validate(Object o) throws Exception {

        CategoryOfCommodity categoryOfCommodity = (CategoryOfCommodity) o;

        if(categoryOfCommodity.getNameOfCategory().isEmpty()){
            throw new CategoryOfCommodityException(CategoryOfCommodityValidatorMessage.CATEGORY_FIELD_EMPTY);
        }else if(categoryOfCommodityDao.findByNameOfCategory(categoryOfCommodity.getNameOfCategory()) != null){
            throw new CategoryOfCommodityException(CategoryOfCommodityValidatorMessage.CATEGORY_ALREADY_EXIST);
        }

    }
}
