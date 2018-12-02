package org.zeti.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zeti.medical.entity.Disposition;

public interface DispositionRepository extends JpaRepository<Disposition, Integer>
{
}
