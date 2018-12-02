package org.zeti.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zeti.medical.entity.Assessment;

public interface AssessmentRepository extends JpaRepository<Assessment, Integer>
{
}
