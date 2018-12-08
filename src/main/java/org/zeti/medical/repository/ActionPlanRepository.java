package org.zeti.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zeti.medical.entity.ActionPlan;

public interface ActionPlanRepository extends JpaRepository<ActionPlan, Integer>
{
}
