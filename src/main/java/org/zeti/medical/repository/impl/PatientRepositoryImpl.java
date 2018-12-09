package org.zeti.medical.repository.impl;

import org.zeti.medical.entity.*;
import org.zeti.medical.exception.ResourceNotFound;
import org.zeti.medical.repository.AbstractEntityManager;
import org.zeti.medical.repository.custom.PatientCustomRepository;

import javax.persistence.EntityGraph;
import javax.persistence.Query;
import javax.persistence.Subgraph;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientRepositoryImpl extends AbstractEntityManager implements PatientCustomRepository
{

    @Override
    public Patient findByPatientID(Integer patientID)
    {
        EntityGraph<Patient> entityGraph = entityManager().createEntityGraph(Patient.class);
        CriteriaQuery<Patient> criteriaQuery = criteriaBuilder().createQuery(Patient.class);
        Root<Patient> root = criteriaQuery.from(Patient.class);
        criteriaQuery.select(criteriaBuilder().construct(Patient.class, root.get("lastName"), root.get("firstName"),
                             root.get("middleInitial"), root.get("age"), root.get("birthDate"),
                             root.get("patientID"), root.get("contactNumber"), root.get("civilStatus"),
                             root.get("religion"), root.get("address"), root.get("eduAttainment"), root.get("lmp"),
                             root.get("aog"), root.get("edc"), root.get("dateCreated"), root.get("dateUpdated")));

        if(patientID != null)
        {
            criteriaQuery.where(criteriaBuilder().equal(root.get("patientID"), patientID));
        }
        TypedQuery typedQuery = entityManager()
                    .createQuery(criteriaQuery)
                    .setHint("javax.persistence.loadgraph", entityGraph);
        Patient patient = (Patient) typedQuery.getSingleResult();

        if(patient == null)
        {
            throw new ResourceNotFound("Patient with ID " + patient + " not found.");
        }

        return patient;
    }

    @Override
    public List<Patient> findAllPatient()
    {

        EntityGraph<Patient> entityGraph = entityManager().createEntityGraph(Patient.class);
        CriteriaQuery<Patient> criteriaQuery = criteriaBuilder().createQuery(Patient.class);
        Root<Patient> root = criteriaQuery.from(Patient.class);
        criteriaQuery.select(criteriaBuilder().construct(Patient.class, root.get("lastName"), root.get("firstName"),
                root.get("middleInitial"), root.get("age"), root.get("birthDate"),
                root.get("patientID"), root.get("contactNumber"), root.get("civilStatus"),
                root.get("religion"), root.get("address"), root.get("eduAttainment"), root.get("lmp"),
                root.get("aog"), root.get("edc"), root.get("dateCreated"), root.get("dateUpdated")));

        TypedQuery typedQuery = entityManager()
                .createQuery(criteriaQuery)
                .setHint("javax.persistence.loadgraph", entityGraph);

        List<Patient> patients = typedQuery.getResultList();
        if(patients.isEmpty())
        {
            throw new ResourceNotFound("No result found");
        }

        return patients;
    }

    // to get total page number
    private Integer getLastPageNumber(long recordCount, int pageSize)
    {
        Integer result;

        result = (int) (Math.ceil(recordCount / (double) pageSize));

        return result;
    }


}









//    @Override
//    public Map<String, Object> findAllPatient(Integer pageCurrent, Integer pageSize)
//    {
//        Map<String, Object> results = new HashMap<String, Object>();
//        long recordCount;
//        long pageCount;
//
//        EntityGraph<Patient> patientEntityGraph = entityManager().createEntityGraph(Patient.class);
////        Subgraph<ObstetricalHistory> subgraph = patientEntityGraph.addSubgraph("obstetricalHistory");
////        Subgraph<MedicalHistory> subgraph2 = patientEntityGraph.addSubgraph("medicalHistory");
////        Subgraph<Assessment> subgraph3 = patientEntityGraph.addSubgraph("assessments");
////        Subgraph<Management> subgraph4 = patientEntityGraph.addSubgraph("managements");
////        Subgraph<Disposition> subgraph5 = patientEntityGraph.addSubgraph("dispositions");
//
//        CriteriaQuery<Patient> criteriaQuery = criteriaBuilder().createQuery(Patient.class);
//        Root<Patient> root = criteriaQuery.from(Patient.class);
////        root.fetch("obstetricalHistory");
////        root.fetch("medicalHistory");
////        root.fetch("managements");
////        root.fetch("assessments");
////        root.fetch("dispositions");
//
//        TypedQuery<Patient> typedQuery = entityManager()
//                            .createNamedQuery("findAllPatient", Patient.class);
////        typedQuery.setHint("javax.persistence.loadgraph", patientEntityGraph);
//        recordCount = typedQuery.getResultList().size();
//        results.put("recordCount", recordCount);
//
//        // Pagination
//        typedQuery.setFirstResult((pageCurrent - 1) * pageSize)
//                .setMaxResults(pageSize);
//
//        // current page
//        pageCount = getLastPageNumber(recordCount, pageSize);
//        results.put("pageCount", pageCount);
//
//        List<Patient> patients = typedQuery.getResultList();
//        results.put("patients", patients);
//
//        return results;
//    }