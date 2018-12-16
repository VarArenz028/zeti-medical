package org.zeti.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zeti.medical.entity.ObstetricalRecord;
import org.zeti.medical.repository.custom.ObstetricalRecordCustomRepository;

public interface ObstetricalRecordRepository extends JpaRepository<ObstetricalRecord, Integer>, ObstetricalRecordCustomRepository
{
}
