package org.zeti.medical.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zeti.medical.entity.*;
import org.zeti.medical.repository.*;
import org.zeti.medical.services.PatientServices;

import java.util.Map;

// Business Logic Layer

@Service("patientServices")
@Transactional
public class PatientServicesImpl implements PatientServices
{

    private PatientRepository patientRepository;

    @Autowired
    private AssetManagementFormRepository assetManagementFormRepository;

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Autowired
    private ManagementRepository managementRepository;

    @Autowired
    private DispositionRepository dispositionRepository;

    @Autowired
    public PatientServicesImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient findByPatientID(Integer patientID)
    {
        return patientRepository.findByPatientID(patientID);
    }

    // can use in saving and updating
    // saving without patientID and updating with specific patientID
    @Override
    public void saveAndUpdate(Patient patient)
    {
        patientRepository.save(patient);
    }

    @Override
    public void addAssessmentMgtForm(Integer patientID, AssetManagementForm assetManagementForm)
    {
        Patient patient = patientRepository.findByPatientID(patientID);
        Assessment assessment = assetManagementForm.getAssessment();
        Management management = assetManagementForm.getManagement();
        Disposition disposition = assetManagementForm.getDisposition();

        assetManagementForm.setPatient(patient);
        assetManagementFormRepository.save(assetManagementForm);

        assessment.setAssetManagementForm(assetManagementForm);
        management.setAssetManagementForm(assetManagementForm);
        disposition.setAssetManagementForm(assetManagementForm);

        assessmentRepository.save(assessment);
        managementRepository.save(management);
        dispositionRepository.save(disposition);
    }
}
