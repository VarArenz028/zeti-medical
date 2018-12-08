package org.zeti.medical.services;

import org.zeti.medical.entity.ActionPlan;
import org.zeti.medical.entity.Management;

import java.util.List;

public interface ManagementServices
{

    void addActionPlans(List<ActionPlan> actionPlans, Integer managementID);

    void saveOrUpdate(Management management);
}
