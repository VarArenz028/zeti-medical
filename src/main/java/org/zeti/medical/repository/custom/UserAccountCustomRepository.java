package org.zeti.medical.repository.custom;

import org.zeti.medical.entity.UserAccount;

import java.util.List;

public interface UserAccountCustomRepository
{

    Boolean isUsernameExist(String username);

    Boolean isPasswordExist(String password);

    UserAccount getUserAuthDetailsByUsername(String username);

    // Fields: UserID, Username, Password, Role, Active, IsDeleted, DateCreated, DateUpdated
    List<UserAccount> findAllUser();

    // Fields: UserID, Username, Password, Role, Active, IsDeleted, DateCreated, DateUpdated
    // Extends Person
    List<UserAccount> findAllUserDetails();

    List<UserAccount> findAllInactiveUser();

}
