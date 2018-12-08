package org.zeti.medical.validation.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zeti.medical.services.UserAccountServices;
import org.zeti.medical.validation.ValidUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UsernameConstraintValidator implements ConstraintValidator<ValidUsername, String>
{

    @Autowired
    private UserAccountServices userAccountServices;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context)
    {
        System.out.println("The username is " + username);
        return username != null && !userAccountServices.isUsernameExist(username);
    }
}
