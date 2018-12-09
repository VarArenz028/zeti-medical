package org.zeti.medical.services;

import org.zeti.medical.entity.UserAccount;

import java.util.List;

public interface UserAccountServices
{

    Boolean isPasswordExist(String password);

    Boolean isUsernameExist(String username);

    List<UserAccount> findAllUser();

    List<UserAccount> findAllUserDetails();

    void saveOrUpdate(UserAccount userAccount);

    void deactivateUser(Integer userID);

    void deleteByID(Integer userID);
}
