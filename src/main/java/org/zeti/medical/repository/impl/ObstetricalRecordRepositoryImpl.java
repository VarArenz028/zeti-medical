package org.zeti.medical.repository.impl;

import org.zeti.medical.entity.ObstetricalRecord;
import org.zeti.medical.exception.ResourceNotFound;
import org.zeti.medical.repository.AbstractEntityManager;
import org.zeti.medical.repository.custom.ObstetricalRecordCustomRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

public class ObstetricalRecordRepositoryImpl extends AbstractEntityManager
        implements ObstetricalRecordCustomRepository
{

    @Override
    public ObstetricalRecord findObstetricalRecordByID(Integer obsRecordID)
    {
        ObstetricalRecord obstetricalRecord = null;
        CriteriaQuery<ObstetricalRecord> query = criteriaBuilder().createQuery(ObstetricalRecord.class);
        Root<ObstetricalRecord> root = query.from(ObstetricalRecord.class);
        query.select(criteriaBuilder().construct(ObstetricalRecord.class, root.get("obsRecordID"), root.get("labor"), root.get("proDoneDuringLabor"),
                root.get("amnioticFluid"), root.get("mannerOfDelivery"), root.get("episiotomy"), root.get("perinealLaceration"), root.get("placentalDelivery"), root.get("typeOfPlacenta"),
                root.get("grossPlaclAbnorm"), root.get("cordAbnormalities"), root.get("postpartumProblems"), root.get("condOfMotherAftDelivery"), root.get("vitalSigns"), root.get("anesthesia"),
                root.get("gender"), root.get("weight"), root.get("length"), root.get("apgarScore"), root.get("fetalOutcome"), root.get("dateAndTimeOfDelivery"),
                root.get("attending"), root.get("finalDiagnosis"), root.get("patient")));
        root.fetch("obstetricalRecord", JoinType.LEFT);
        if(obsRecordID != null)
        {
            query.where(criteriaBuilder().equal(root.get("obsRecordID"), obsRecordID));
        }

        TypedQuery<ObstetricalRecord> typedQuery = entityManager().createQuery(query);

        try
        {
            obstetricalRecord = typedQuery.getSingleResult();
        }
        catch (NoResultException e)
        {
            throw new ResourceNotFound("ID with \'" + obsRecordID + "\' not found");
        }

        return obstetricalRecord;
    }
}
