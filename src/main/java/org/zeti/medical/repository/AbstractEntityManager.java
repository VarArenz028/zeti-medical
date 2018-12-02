package org.zeti.medical.repository;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

public abstract class AbstractEntityManager
{
    @PersistenceContext
    private EntityManager entityManager;

    protected CriteriaBuilder criteriaBuilder()
    {
        return entityManager.getCriteriaBuilder();
    }

    protected EntityManager entityManager()
    {
        return this.entityManager;
    }

    protected Session session()
    {
        return this.entityManager.unwrap(Session.class);
    }
}
