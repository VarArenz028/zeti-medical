package org.zeti.medical.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "Patient")
@DynamicInsert
@DynamicUpdate
@JsonRootName("Patient")
@JsonFilter("PatientFilter")
@Where(clause = "is_deleted = false")
public class Patient extends Person implements Serializable
{

    @Id
    @Column(name = "patientID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientID;

    @Column(name = "contactNumber",
            length = 30)
    @Size(max = 30, message = "{validation.contact.number.size}")
    private String contactNumber;

    @Column(name = "civilStatus",
            length = 20)
    @Size(max = 20, message = "{validation.civil.number.size}")
    private String civilStatus;

    @Column(name = "religion",
            length = 80)
    @Size(max = 80, message = "{validation.religion.number.size}")
    private String religion;

    @Column(name = "address",
            length = 150)
    @Size(max = 150, message = "{validation.address.number.size}")
    private String address;

    //Educational Attainment
    @Column(name = "eduAttainment",
            length = 100)
    @Size(max = 100, message = "{validation.education.number.size}")
    private String eduAttainment;

    @Column(name = "lmp",
            length = 50)
    @Size(max = 100, message = "{validation.lmp.number.size}")
    private String lmp;

    @Column(name = "aog",
            length = 50)
    @Size(max = 100, message = "{validation.education.number.size}")
    private String aog;

    @Column(name = "edc",
            length = 50)
    @Size(max = 100, message = "{validation.education.number.size}")
    private String edc;

    @Column(name = "dateCreated",
            nullable = false,
            updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @CreationTimestamp
    private LocalDate dateCreated;

    @Column(name = "dateUpdated",
            nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @UpdateTimestamp
    private LocalDate dateUpdated;

    @Column(name = "isDeleted",
            columnDefinition = "bit",
            nullable = false)
    private boolean isDeleted = false;

    @OneToOne(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL,
              mappedBy = "patient")
    private ObstetricalHistory obstetricalHistory;

    @OneToOne(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL,
              mappedBy = "patient")
    private MedicalHistory medicalHistory;

    @OneToMany(fetch = FetchType.LAZY,
               mappedBy = "patient")
    @JsonManagedReference
    private Set<AssetManagementForm> assetManagementForms = new LinkedHashSet<>();


    public Patient() {
    }

    public Patient(String lastName, String firstName, String middleInitial, Integer age, LocalDate birthDate, Integer patientID, @Size(max = 30, message = "{validation.contact.number.size}") String contactNumber, @Size(max = 20, message = "{validation.civil.number.size}") String civilStatus, @Size(max = 80, message = "{validation.religion.number.size}") String religion, @Size(max = 150, message = "{validation.address.number.size}") String address, @Size(max = 100, message = "{validation.education.number.size}") String eduAttainment, @Size(max = 100, message = "{validation.lmp.number.size}") String lmp, @Size(max = 100, message = "{validation.education.number.size}") String aog, @Size(max = 100, message = "{validation.education.number.size}") String edc, LocalDate dateCreated, LocalDate dateUpdated) {
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public ObstetricalHistory getObstetricalHistory() {
        return obstetricalHistory;
    }

    public void setObstetricalHistory(ObstetricalHistory obstetricalHistory) {
        this.obstetricalHistory = obstetricalHistory;
    }

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public Set<AssetManagementForm> getAssetManagementForms() {
        return assetManagementForms;
    }

    public void setAssetManagementForms(Set<AssetManagementForm> assetManagementForms) {
        this.assetManagementForms = assetManagementForms;
    }
}
