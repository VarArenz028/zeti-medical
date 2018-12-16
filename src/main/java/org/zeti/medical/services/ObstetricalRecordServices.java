package org.zeti.medical.services;

import org.zeti.medical.entity.ObstetricalRecord;

public interface ObstetricalRecordServices
{

    ObstetricalRecord findByID(Integer obsRecordID);

    void updateObstetricalRecord(ObstetricalRecord obstetricalRecord);

    void saveOrUpdate(ObstetricalRecord obstetricalRecord);

    void save(ObstetricalRecord obstetricalRecord, Integer patientID);

}
