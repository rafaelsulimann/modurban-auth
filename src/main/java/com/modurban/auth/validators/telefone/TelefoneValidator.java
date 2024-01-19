package com.modurban.auth.validators.telefone;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import main.java.com.modurban.auth.utils.Regex;

public class TelefoneValidator implements ConstraintValidator<Telefone, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!StringUtils.hasText(value)) {
            return false;
        }
        return value.matches(Regex.CELULAR);
    }

}



