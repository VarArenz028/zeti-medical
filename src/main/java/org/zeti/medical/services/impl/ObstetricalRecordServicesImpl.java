package org.zeti.medical.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.zeti.medical.entity.ObstetricalRecord;
import org.zeti.medical.entity.Patient;
import org.zeti.medical.exception.ResourceExist;
import org.zeti.medical.exception.ResourceNotFound;
import org.zeti.medical.repository.ObstetricalRecordRepository;
import org.zeti.medical.repository.PatientRepository;
import org.zeti.medical.services.ObstetricalRecordServices;

import java.util.Optional;

@Service("obstetricalRecordServices")
@Transactional(isolation = Isolation.READ_COMMITTED)
public class ObstetricalRecordServicesImpl implements ObstetricalRecordServices
{

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ObstetricalRecordRepository obstetricalRecordRepository;

    @Override
    public ObstetricalRecord findByID(Integer obsRecordID)
    {
        Optional<ObstetricalRecord> obstetricalRecord = obstetricalRecordRepository.findById(obsRecordID);
        if(!obstetricalRecord.isPresent())
        {
            throw new ResourceNotFound("ObstetricalRecord with ID " + "\'" + obsRecordID + "\'" + " not found");
        }
        return obstetricalRecord.get();
    }

    // Manually updating the data because foreign key turns to null
    @Override
    public void updateObstetricalRecord(ObstetricalRecord obstetricalRecord)
    {
        ObstetricalRecord record = obstetricalRecordRepository
                        .findObstetricalRecordByID(obstetricalRecord.getObsRecordID());
        record.setLabor(obstetricalRecord.getLabor());
        record.setProDoneDuringLabor(obstetricalRecord.getProDoneDuringLabor());
        record.setAmnioticFluid(obstetricalRecord.getAmnioticFluid());
        record.setMannerOfDelivery(obstetricalRecord.getMannerOfDelivery());
        record.setEpisiotomy(obstetricalRecord.getEpisiotomy());
        record.setPerinealLaceration(obstetricalRecord.getPerinealLaceration());
        record.setPlacentalDelivery(obstetricalRecord.getPlacentalDelivery());
        record.setTypeOfPlacenta(obstetricalRecord.getTypeOfPlacenta());
        record.setGrossPlaclAbnorm(obstetricalRecord.getGrossPlaclAbnorm());
        record.setCordAbnormalities(obstetricalRecord.getCordAbnormalities());
        record.setPostpartumProblems(obstetricalRecord.getPostpartumProblems());
        record.setCondOfMotherAftDelivery(obstetricalRecord.getCondOfMotherAftDelivery());
        record.setVitalSigns(obstetricalRecord.getVitalSigns());
        record.setAnesthesia(obstetricalRecord.getAnesthesia());
        record.setGender(obstetricalRecord.getGender());
        record.setWeight(obstetricalRecord.getWeight());
        record.setLength(obstetricalRecord.getLength());
        record.setApgarScore(obstetricalRecord.getApgarScore());
        record.setFetalOutcome(obstetricalRecord.getFetalOutcome());
        record.setDateAndTimeOfDelivery(obstetricalRecord.getDateAndTimeOfDelivery());
        record.setAttending(obstetricalRecord.getAttending());
        record.setFinalDiagnosis(obstetricalRecord.getFinalDiagnosis());
        obstetricalRecordRepository.save(record);
    }


    @Override
    public void saveOrUpdate(ObstetricalRecord obstetricalRecord)
    {
        obstetricalRecordRepository.save(obstetricalRecord);
    }

    @Override
    public void save(ObstetricalRecord obstetricalRecord, Integer patientID)
    {
        Optional<Patient> patient = patientRepository.findById(patientID);
        if(!patient.isPresent())
        {
            throw new ResourceNotFound("Patient with ID " + "\'" + patientID + "\'" + " not found");
        }
        else
        {
            if(patient.get().getObstetricalRecord() == null)
            {
                obstetricalRecord.setPatient(patient.get());
                obstetricalRecordRepository.save(obstetricalRecord);
                patientRepository.save(patient.get());
            }
            else
            {
                throw new ResourceExist("Resource already exist");
            }
        }
    }

}
