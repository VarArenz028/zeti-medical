package org.zeti.medical.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.zeti.medical.entity.UserAccount;
import org.zeti.medical.repository.UserAccountRepository;
import org.zeti.medical.services.UserAccountServices;

import java.util.List;

@Service("userAccountServices")
@Transactional
public class UserAccountServicesImpl implements UserAccountServices
{

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public boolean isPasswordExist(String password)
    {
        return userAccountRepository.existsByPassword(password);
    }

    @Override
    public boolean isUsernameExist(String username)
    {
        return userAccountRepository.existsByUsername(username);
    }

    @Override
    public List<UserAccount> findAllUser()
    {
        return userAccountRepository.findAllUser();
    }

    @Override
    public List<UserAccount> findAllUserDetails()
    {
        return userAccountRepository.findAllUserDetails();
    }

    @Override
    public void saveOrUpdate(UserAccount userAccount)
    {
        userAccountRepository.save(userAccount);
    }


}
