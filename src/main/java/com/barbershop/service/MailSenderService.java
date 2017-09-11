package com.barbershop.service;

/**
 * Created by pavelsavchenko on 09.06.17.
 */
public interface MailSenderService {

    void senfMail(String theme, String mailBody, String email);
}
