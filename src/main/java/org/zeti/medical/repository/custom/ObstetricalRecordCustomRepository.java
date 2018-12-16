package org.zeti.medical.repository.custom;

import org.zeti.medical.entity.ObstetricalRecord;

import java.util.List;

public interface ObstetricalRecordCustomRepository
{
    ObstetricalRecord findObstetricalRecordByID(Integer obsRecordID);

}
