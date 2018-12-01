package org.zeti.medical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Patient")
@DynamicInsert
@DynamicUpdate
public class Patient extends Person implements Serializable
{

    @Id
    @Column(name = "patientID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientID;

    @Column(name = "contactNumber",
            length = 30)
    private String contactNumber;

    @Column(name = "civilStatus",
            length = 20)
    private String civilStatus;

    @Column(name = "religion",
            length = 80)
    private String religion;

    @Column(name = "address",
            length = 150)
    private String address;

    //Educational Attainment
    @Column(name = "eduAttainment",
            length = 100)
    private String eduAttainment;

    @Column(name = "lmp",
            length = 50)
    private String lmp;

    @Column(name = "aog",
            length = 50)
    private String aog;

    @Column(name = "edc",
            length = 50)
    private String edc;

    @Column(name = "dateCreated",
            nullable = false,
            updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dateCreated;

    @Column(name = "dateUpdated",
            nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dateUpdated;

    @OneToOne(fetch = FetchType.LAZY,
              mappedBy = "patient",
              cascade = CascadeType.ALL)
    private ObstetricalHistory obstetricalHistory;

    @OneToOne(fetch = FetchType.LAZY,
            mappedBy = "patient",
            cascade = CascadeType.ALL)
    private MedicalHistory medicalHistory;

    @OneToMany(mappedBy = "patient",
               cascade = CascadeType.ALL,
               fetch = FetchType.LAZY)
    private Set<AssetManagementForm> assetManagementForms = new LinkedHashSet<>();

    public Patient() {
    }

    public Patient(Integer patientID, String contactNumber, String civilStatus, String religion, String address, String eduAttainment, String lmp, String aog, String edc, LocalDate dateCreated, LocalDate dateUpdated) {
        this.patientID = patientID;
        this.contactNumber = contactNumber;
        this.civilStatus = civilStatus;
        this.religion = religion;
        this.address = address;
        this.eduAttainment = eduAttainment;
        this.lmp = lmp;
        this.aog = aog;
        this.edc = edc;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public Patient(Integer patientID, String contactNumber, String civilStatus, String religion, String address, String eduAttainment, String lmp, String aog, String edc, LocalDate dateCreated, LocalDate dateUpdated, ObstetricalHistory obstetricalHistory, MedicalHistory medicalHistory, Set<AssetManagementForm> assetManagementForms) {
        this.patientID = patientID;
        this.contactNumber = contactNumber;
        this.civilStatus = civilStatus;
        this.religion = religion;
        this.address = address;
        this.eduAttainment = eduAttainment;
        this.lmp = lmp;
        this.aog = aog;
        this.edc = edc;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.obstetricalHistory = obstetricalHistory;
        this.medicalHistory = medicalHistory;
        this.assetManagementForms = assetManagementForms;
    }

    public Patient(String lastName, String firstName, String middleInitial, Integer age, LocalDate birthDate, Integer patientID, String contactNumber, String civilStatus, String religion, String address, String eduAttainment, String lmp, String aog, String edc, LocalDate dateCreated, LocalDate dateUpdated, ObstetricalHistory obstetricalHistory, MedicalHistory medicalHistory, Set<AssetManagementForm> assetManagementForms) {
        super(lastName, firstName, middleInitial, age, birthDate);
        this.patientID = patientID;
        this.contactNumber = contactNumber;
        this.civilStatus = civilStatus;
        this.religion = religion;
        this.address = address;
        this.eduAttainment = eduAttainment;
        this.lmp = lmp;
        this.aog = aog;
        this.edc = edc;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.obstetricalHistory = obstetricalHistory;
        this.medicalHistory = medicalHistory;
        this.assetManagementForms = assetManagementForms;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEduAttainment() {
        return eduAttainment;
    }

    public void setEduAttainment(String eduAttainment) {
        this.eduAttainment = eduAttainment;
    }

    public String getLmp() {
        return lmp;
    }

    public void setLmp(String lmp) {
        this.lmp = lmp;
    }

    public String getAog() {
        return aog;
    }

    public void setAog(String aog) {
        this.aog = aog;
    }

    public String getEdc() {
        return edc;
    }

    public void setEdc(String edc) {
        this.edc = edc;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDate dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
