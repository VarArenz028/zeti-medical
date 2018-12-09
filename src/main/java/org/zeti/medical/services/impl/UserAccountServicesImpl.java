package org.zeti.medical.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.zeti.medical.entity.UserAccount;
import org.zeti.medical.exception.ResourceNotFound;
import org.zeti.medical.repository.UserAccountRepository;
import org.zeti.medical.services.UserAccountServices;

import java.util.List;
import java.util.Optional;

@Service("userAccountServices")
@Transactional
public class UserAccountServicesImpl implements UserAccountServices
{

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public Boolean isPasswordExist(String password)
    {
        return userAccountRepository.isPasswordExist(password);
    }

    @Override
    public Boolean isUsernameExist(String username)
    {
        return userAccountRepository.isUsernameExist(username);
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

    @Override
    public void deactivateUser(Integer userID)
    {
        Optional<UserAccount> userAccount = userAccountRepository.findById(userID);

        if(!userAccount.isPresent())
        {
            throw new ResourceNotFound("User not found with userID: " + userID);
        }
        userAccount.get().setActive(false);
        userAccountRepository.save(userAccount.get());

    }

    @Override
    public void deleteByID(Integer userID)
    {
        userAccountRepository.deleteById(userID);
    }


}
