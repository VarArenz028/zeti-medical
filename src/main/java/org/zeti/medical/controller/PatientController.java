package org.zeti.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.zeti.medical.entity.ActionPlan;
import org.zeti.medical.entity.AssetManagementForm;
import org.zeti.medical.entity.Management;
import org.zeti.medical.entity.Patient;
import org.zeti.medical.json.filter.JsonFilter;
import org.zeti.medical.json.field.PatientView;
import org.zeti.medical.services.ManagementServices;
import org.zeti.medical.services.PatientServices;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;


/*
    @Author Var Arenz Villarino
 */

// Entry point or Controller layer

@RestController
@RequestMapping(value = "/zeti")
public class PatientController
{

    @Autowired
    private PatientServices patientServices;

    @Autowired
    private ManagementServices managementServices;

    @Autowired
    private JsonFilter jsonFilter;

    // accessible by Admin, Midwife and OB
    @GetMapping("/patients")
    public ResponseEntity<?> getPatients()
    {
        return patientServices.findAllPatient();
    }

    // accessible by Admin, Midwife and OB
    @PostMapping(value = "/patient-registration")
    public ResponseEntity<?> registerPatient(@RequestBody @Valid Patient patient)
    {
        patientServices.saveAndUpdate(patient);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(patient.getPatientID()).toUri();
        return ResponseEntity.created(location).body("Successfully Created");
    }

    // accessible by Admin, Midwife and OB
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
    @PostMapping("/action-plan")
    public ResponseEntity<?> addActionPlan(@RequestBody @Valid List<ActionPlan> actionPlans,
                                           @RequestParam(name = "managementID") Integer managementID)
    {
        managementServices.addActionPlans(actionPlans, managementID);
        return ResponseEntity.created(null).body("Successfully Added");
    }

    // accessible by Admin, Midwife and OB
    @PutMapping("/update-patient-information")
    public ResponseEntity<?> updatePatientInformation(@RequestBody @Valid Patient patient)
    {
        patientServices.saveAndUpdate(patient);
        return ResponseEntity.ok("Successfully Updated");
    }
}
