package org.zeti.medical.validation.validator;


import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.zeti.medical.services.UserAccountServices;
import org.zeti.medical.validation.ValidPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String>
{

    @Autowired
    private UserAccountServices userAccountServices;

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context)
    {
        return password != null && !userAccountServices.isPasswordExist(password);
    }
}
