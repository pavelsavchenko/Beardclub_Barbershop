package com.barbershop.editors;

import com.barbershop.entity.Subcategory;
import com.barbershop.service.SubcategoryService;

import java.beans.PropertyEditorSupport;

/**
 * Created by pavelsavchenko on 30.05.17.
 */
public class SubcategoryEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String idFromJSP) throws IllegalArgumentException {

        Subcategory subcategory = new Subcategory();

        subcategory.setId(Integer.parseInt(idFromJSP));

        setValue(subcategory);
    }
}
