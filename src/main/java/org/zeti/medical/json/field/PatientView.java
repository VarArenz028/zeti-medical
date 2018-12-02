package org.zeti.medical.json.field;


import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class PatientView
{
    private Set<String> patientFields = new HashSet<>(Arrays.asList("patientID", "lastName"));

    public Set<String> getPatientFields() {
        return patientFields;
    }
}
