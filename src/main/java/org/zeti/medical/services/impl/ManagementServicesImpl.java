package org.zeti.medical.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zeti.medical.entity.ActionPlan;
import org.zeti.medical.entity.Management;
import org.zeti.medical.repository.ActionPlanRepository;
import org.zeti.medical.repository.ManagementRepository;
import org.zeti.medical.services.ManagementServices;

import java.util.List;
import java.util.Optional;

@Service("managementServices")
@Transactional
public class ManagementServicesImpl implements ManagementServices
{

    @Autowired
    private ManagementRepository managementRepository;

    @Autowired
    private ActionPlanRepository actionPlanRepository;

    // 12-5-2018
    // modified this
    @Override
    public void addActionPlans(List<ActionPlan> actionPlans, Integer managementID)
    {
        Management management = managementRepository.findRefferenceByID(managementID);
        for(ActionPlan actionPlan : actionPlans)
        {
            actionPlan.setManagement(management);
            actionPlanRepository.save(actionPlan);
        }
    }

    @Override
    public void saveOrUpdate(Management management)
    {
        managementRepository.save(management);
    }
}
