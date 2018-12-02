package org.zeti.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.zeti.medical.entity.AssetManagementForm;
import org.zeti.medical.entity.Patient;
import org.zeti.medical.json.filter.JSONFilter;
import org.zeti.medical.json.field.PatientView;
import org.zeti.medical.services.PatientServices;
import javax.validation.Valid;
import java.net.URI;

// Entry point or Controller layer

@RestController
@RequestMapping(value = "/zeti")
public class PatientController
{

    @Autowired
    private PatientServices patientServices;

    @Autowired
    private JSONFilter jsonFilter;

    @Autowired
    private PatientView patientView;


    // accessible by Admin, Midwife and OB
    @PostMapping(value = "/register-patient")
    public ResponseEntity<?> registerPatient(@RequestBody @Valid Patient patient)
    {
        patientServices.saveAndUpdate(patient);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(patient.getPatientID()).toUri();
        return ResponseEntity.created(location).body("Successfully Created");
    }
    @PostMapping("/assessment-management-form")
    public ResponseEntity addAssessmentMgtForm(@RequestParam("patientID") Integer patientID,
                                               @RequestBody @Valid AssetManagementForm assetMgtForm)
    {
        patientServices.addAssessmentMgtForm(patientID, assetMgtForm);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(assetMgtForm.getAssetMgtID()).toUri();
        return ResponseEntity.created(location).body("Successfully Added");
    }

    // accessible by Admin, Midwife and OB
    @PutMapping("/update-patient-information")
    public ResponseEntity<?> updatePatientInformation(@RequestBody @Valid Patient patient)
    {
        patientServices.saveAndUpdate(patient);
        return ResponseEntity.ok("Successfully Updated");
    }
}
