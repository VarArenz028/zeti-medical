package org.zeti.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zeti.medical.entity.Management;
import org.zeti.medical.repository.custom.ManagementCustomRepository;

public interface ManagementRepository extends JpaRepository<Management, Integer>, ManagementCustomRepository
{
}
