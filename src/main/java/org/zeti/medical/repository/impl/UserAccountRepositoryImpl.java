package org.zeti.medical.repository.impl;

import org.zeti.medical.entity.UserAccount;
import org.zeti.medical.exception.ResourceNotFound;
import org.zeti.medical.repository.AbstractEntityManager;
import org.zeti.medical.repository.custom.UserAccountCustomRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class UserAccountRepositoryImpl extends AbstractEntityManager
        implements UserAccountCustomRepository
{
    @Override
    public List<UserAccount> findAllUser()
    {
        TypedQuery<UserAccount> typedQuery = entityManager()
                .createQuery("SELECT NEW UserAccount(userID, username, role, active, " +
                               "isDeleted, dateCreated, dateUpdated) FROM UserAccount", UserAccount.class);

        List<UserAccount> userAccounts = typedQuery.getResultList();

        if(userAccounts.isEmpty())
        {
            throw new ResourceNotFound("No users found");
        }

        return userAccounts;
    }

    @Override
    public List<UserAccount> findAllUserDetails()
    {
        TypedQuery<UserAccount> typedQuery = entityManager()
                .createQuery("SELECT NEW UserAccount(lastName, firstName, middleInitial, age, " +
                               "birthDate, userID, username, role, active, dateCreated, dateUpdated) FROM UserAccount",
                                UserAccount.class);
        List<UserAccount> userAccounts = typedQuery.getResultList();

        if(userAccounts.isEmpty())
        {
            throw new ResourceNotFound("No users found");
        }

        return userAccounts;
    }
}
