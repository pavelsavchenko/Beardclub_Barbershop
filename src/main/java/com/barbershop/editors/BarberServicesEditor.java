package com.barbershop.editors;

import com.barbershop.entity.ServicesOfBarber;

import java.beans.PropertyEditorSupport;

/**
 * Created by pavelsavchenko on 30.05.17.
 */
public class BarberServicesEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String idFromJSP) throws IllegalArgumentException {

        ServicesOfBarber servicesOfBarber = new ServicesOfBarber();
        servicesOfBarber.setId(Integer.parseInt(idFromJSP));

        setValue(servicesOfBarber);
    }
}
