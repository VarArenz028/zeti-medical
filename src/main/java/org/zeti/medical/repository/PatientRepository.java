package org.zeti.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zeti.medical.entity.Patient;
import org.zeti.medical.repository.custom.PatientCustomRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer>, PatientCustomRepository
{
}
