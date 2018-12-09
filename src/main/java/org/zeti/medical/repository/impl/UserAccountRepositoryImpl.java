package org.zeti.medical.repository.impl;

import org.zeti.medical.entity.UserAccount;
import org.zeti.medical.exception.ResourceNotFound;
import org.zeti.medical.repository.AbstractEntityManager;
import org.zeti.medical.repository.custom.UserAccountCustomRepository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserAccountRepositoryImpl extends AbstractEntityManager
        implements UserAccountCustomRepository
{
    @Override
    public Boolean isUsernameExist(String username)
    {
        Boolean isUsernameExist = false;
        CriteriaQuery<Boolean> query = criteriaBuilder().createQuery(Boolean.class);
        Root<UserAccount> root = query.from(UserAccount.class);
        if(username != null)
        {
            query.select(criteriaBuilder().literal(true));
            Predicate preUsername = criteriaBuilder().equal(root.get("username"), username);
            Predicate preDeactivated = criteriaBuilder().or(criteriaBuilder().equal(root.get("active"), true),
                                     criteriaBuilder().equal(root.get("active"), false));
            query.where(criteriaBuilder().and(preUsername, preDeactivated));

        }
        TypedQuery<Boolean> typedQuery = entityManager().createQuery(query);
        try
        {
            isUsernameExist = typedQuery.getSingleResult();
        }
        catch (NoResultException e)
        {
            return isUsernameExist;
        }
        return isUsernameExist;
    }

    @Override
    public Boolean isPasswordExist(String password)
    {
        Boolean isPasswordExist = false;
        CriteriaQuery<Boolean> query = criteriaBuilder().createQuery(Boolean.class);
        Root<UserAccount> root = query.from(UserAccount.class);
        if(password != null)
        {
            query.select(criteriaBuilder().literal(true));
            Predicate preUsername = criteriaBuilder().equal(root.get("password"), password);
            Predicate preDeactivated = criteriaBuilder().or(criteriaBuilder().equal(root.get("active"), true),
                    criteriaBuilder().equal(root.get("active"), false));
            query.where(criteriaBuilder().and(preUsername, preDeactivated));
        }
        TypedQuery<Boolean> typedQuery = entityManager().createQuery(query);
        try
        {
            isPasswordExist = typedQuery.getSingleResult();
        }
        catch (NoResultException e)
        {
            return isPasswordExist;
        }
        return isPasswordExist;
    }

    @Override
    public List<UserAccount> findAllUser()
    {
        TypedQuery<UserAccount> typedQuery = entityManager()
                .createQuery("SELECT NEW UserAccount(userID, username, role, active, " +
                               "isDeleted, dateCreated, dateUpdated) FROM UserAccount where active = true", UserAccount.class);

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
                               "birthDate, userID, username, role, active, dateCreated, dateUpdated) FROM UserAccount where active = true",
                                UserAccount.class);
        List<UserAccount> userAccounts = typedQuery.getResultList();

        if(userAccounts.isEmpty())
        {
            throw new ResourceNotFound("No users found");
        }

        return userAccounts;
    }

    // to get total page number
    private Integer getLastPageNumber(long recordCount, int pageSize)
    {
        Integer result;

        result = (int) (Math.ceil(recordCount / (double) pageSize));

        return result;
    }

}
