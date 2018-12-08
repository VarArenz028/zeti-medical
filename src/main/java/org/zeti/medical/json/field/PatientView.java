package org.zeti.medical.json.field;


import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class PatientView
{
    private Set<String> patientFields;

    public Set<String> getPatientFields()
    {
        return patientFields = new HashSet<>(Arrays.asList(
                "patientID",
                "lastName",
                "firstName",
                "middleInitial",
                "age",
                "birthDate",
                "contactNumber",
                "civilStatus",
                "religion",
                "address",
                "eduAttainment",
                "lmp",
                "aog",
                "edc",
                "dateCreated",
                "dateUpdated"
        ));
    }
}
