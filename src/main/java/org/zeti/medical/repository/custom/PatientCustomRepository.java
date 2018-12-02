package org.zeti.medical.repository.custom;


import org.zeti.medical.entity.Patient;

import java.util.Map;

public interface PatientCustomRepository
{
    Patient findByPatientID(Integer patientID);
}
