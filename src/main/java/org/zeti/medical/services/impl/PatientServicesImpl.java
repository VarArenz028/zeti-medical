package org.zeti.medical.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zeti.medical.entity.*;
import org.zeti.medical.json.field.PatientView;
import org.zeti.medical.json.filter.JsonFilter;
import org.zeti.medical.repository.*;
import org.zeti.medical.services.PatientServices;

import java.util.List;
import java.util.Map;

// Business Logic Layer

@Service("patientServices")
@Transactional
public class PatientServicesImpl implements PatientServices
{

    private PatientRepository patientRepository;

    @Autowired
    private AssetManagementFormRepository assetManagementFormRepository;

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Autowired
    private ManagementRepository managementRepository;

    @Autowired
    private DispositionRepository dispositionRepository;

    @Autowired
    private ConsultationHistoryRepository consultationHistoryRepository;

    @Autowired
    private JsonFilter jsonFilter;

    @Autowired
    private PatientView patientView;

    @Autowired
    public PatientServicesImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient findByPatientID(Integer patientID)
    {
        return patientRepository.findByPatientID(patientID);
    }

    @Override
    public ResponseEntity<?> findAllPatient()
    {
        MappingJacksonValue jacksonValue = jsonFilter.filterResponse("PatientFilter",
                    patientView.getPatientFields(), patientRepository.findAllPatient());
        return new ResponseEntity<>(jacksonValue, HttpStatus.OK);
    }

    // can use in saving and updating
    // saving without patientID and updating with specific patientID
    @Override
    public void saveAndUpdate(Patient patient)
    {
        patientRepository.save(patient);
    }

    @Override
    public void addAssessmentMgtForm(Integer patientID, AssetManagementForm assetManagementForm)
    {
        Patient patient = patientRepository.findByPatientID(patientID);
        Assessment assessment = assetManagementForm.getAssessment();
        Management management = assetManagementForm.getManagement();
        Disposition disposition = assetManagementForm.getDisposition();
        ConsultationHistory consultationHistory = assetManagementForm.getConsultationHistory();


        assetManagementForm.setPatient(patient);
        assetManagementFormRepository.save(assetManagementForm);

        assessment.setAssetManagementForm(assetManagementForm);
        management.setAssetManagementForm(assetManagementForm);
        disposition.setAssetManagementForm(assetManagementForm);
        consultationHistory.setAssetManagementForm(assetManagementForm);

        assessmentRepository.save(assessment);
        managementRepository.save(management);
        dispositionRepository.save(disposition);
        consultationHistoryRepository.save(consultationHistory);
    }
}
