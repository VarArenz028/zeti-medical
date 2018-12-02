package org.zeti.medical.services;

import org.springframework.http.ResponseEntity;
import org.zeti.medical.entity.AssetManagementForm;
import org.zeti.medical.entity.Patient;

public interface PatientServices
{

    Patient findByPatientID(Integer patientID);

    void saveAndUpdate(Patient patient);

    void addAssessmentMgtForm(Integer patientID, AssetManagementForm assetManagementForm);
}
