package com.barbershop.editors;

import com.barbershop.entity.CategoryOfCommodity;

import java.beans.PropertyEditorSupport;

/**
 * Created by pavelsavchenko on 30.05.17.
 */
public class CategoryEditor extends PropertyEditorSupport {


    @Override
    public void setAsText(String idFromJSP) throws IllegalArgumentException {

        CategoryOfCommodity categoryOfCommodity = new CategoryOfCommodity();
        categoryOfCommodity.setId(Integer.parseInt(idFromJSP));

        setValue(categoryOfCommodity);

    }
}
