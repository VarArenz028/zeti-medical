package org.zeti.medical.repository.custom;

import org.zeti.medical.entity.Management;

public interface ManagementCustomRepository
{
    Management findRefferenceByID(Integer managementID);
}
