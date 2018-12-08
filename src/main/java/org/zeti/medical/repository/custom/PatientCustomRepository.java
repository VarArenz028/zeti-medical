package org.zeti.medical.repository.custom;


import org.zeti.medical.entity.Patient;

import java.util.List;
import java.util.Map;

public interface PatientCustomRepository
{
    Patient findByPatientID(Integer patientID);

    List<Patient> findAllPatient();
}
