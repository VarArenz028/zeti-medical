package org.zeti.medical.repository.impl;

import org.zeti.medical.entity.Management;
import org.zeti.medical.repository.AbstractEntityManager;
import org.zeti.medical.repository.custom.ManagementCustomRepository;

public class ManagementRepositoryImpl extends AbstractEntityManager implements ManagementCustomRepository
{
    @Override
    public Management findRefferenceByID(Integer managementID)
    {
        Management management = entityManager().getReference(Management.class, managementID);
        return management;
    }
}
