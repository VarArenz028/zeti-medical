package org.zeti.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.zeti.medical.entity.ObstetricalRecord;
import org.zeti.medical.services.ObstetricalRecordServices;

import javax.validation.Valid;
import java.net.URI;

/*
    Note: Record cannot be deleted but it can be updated.
          If record already exist, user should prompt that record already exist, just update the record
 */

/*
    Notes:
    - please delete isDeleted column
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/zeti/obstetrical-records")
@PreAuthorize("hasRole('Admin')")
public class ObstetricalRecordController
{

    @Autowired
    private ObstetricalRecordServices obstetricalRecordServices;

    @GetMapping("/{obsRecordID}")
    public ResponseEntity<?> getObstetricalRecordByID(@PathVariable(name = "obsRecordID") Integer obsRecordID)
    {
        ObstetricalRecord obstetricalRecord = obstetricalRecordServices.findByID(obsRecordID);
        return ResponseEntity.ok(obstetricalRecord);
    }

    @PostMapping
    public ResponseEntity<?> createObstetricalRecord(@RequestBody @Valid ObstetricalRecord obstetricalRecord,
                                                     @RequestParam(name = "patientID") Integer patientID)
    {
        obstetricalRecordServices.save(obstetricalRecord, patientID);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(obstetricalRecord.getObsRecordID()).toUri();

        return ResponseEntity.created(location).body("Successfully created");
    }

    @PutMapping
    public ResponseEntity<?> updateObstetricalRecord(@RequestBody @Valid ObstetricalRecord obstetricalRecord)
    {
        obstetricalRecordServices.updateObstetricalRecord(obstetricalRecord);
        return ResponseEntity.ok("ID with \'" + obstetricalRecord.getObsRecordID() + "\' successfully updated");
    }

}
