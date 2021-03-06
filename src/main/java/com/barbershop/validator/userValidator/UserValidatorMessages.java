package com.barbershop.validator.userValidator;

/**
 * Created by pavelsavchenko on 29.05.17.
 */
public interface UserValidatorMessages {

    String EMPTY_USERNAME_FIELD = "EMPTY USERNAME FIELD";
    String USERNAME_ALREADY_EXIST = "USERNAME ALREADY EXIST";
    String MISSING_CHARACTER = "MISSING CHARACTER @";
    String EMPTY_EMAIL_FIELD = "EMPTY EMAIL FIELD";
    String EMAIL_ALREADY_EXIST = "EMAIL ALREADY EXIST";
    String EMPTY_PASSWORD_FIELD = "EMPTY PASSWORD FIELD";
    String INVALID_LENGTH = "INVALID LENGTH! LENGTH SHOULD BE FROM 4 CHARACTERS";
    String PHONE_LENGTH = "INVALID LENGTH!";
    String EMPTY_PHONE_NUMBER_FIELD = "EMPTY PHONE NUMBER FIELD";
    String WRONG_CHARACTER = "WRONG CHARACTER";
}
