package org.zeti.medical.services;

import org.springframework.http.ResponseEntity;
import org.zeti.medical.entity.AssetManagementForm;
import org.zeti.medical.entity.Patient;

import java.util.List;

public interface PatientServices
{

    Patient findByPatientID(Integer patientID);

    // List the Patient Entity without its children entities
    ResponseEntity<?> findAllPatient();

    void saveAndUpdate(Patient patient);

    void addAssessmentMgtForm(Integer patientID, AssetManagementForm assetManagementForm);
}
