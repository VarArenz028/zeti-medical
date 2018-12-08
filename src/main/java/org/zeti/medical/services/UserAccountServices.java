package org.zeti.medical.services;

import org.zeti.medical.entity.UserAccount;

import java.util.List;

public interface UserAccountServices
{

    boolean isPasswordExist(String password);

    boolean isUsernameExist(String username);

    List<UserAccount> findAllUser();

    List<UserAccount> findAllUserDetails();

    void saveOrUpdate(UserAccount userAccount);
}
