package org.zeti.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zeti.medical.entity.ConsultationHistory;

public interface ConsultationHistoryRepository extends JpaRepository<ConsultationHistory, Integer>
{
}
