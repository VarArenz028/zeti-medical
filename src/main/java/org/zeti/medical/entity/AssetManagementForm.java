package org.zeti.medical.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "AssetManagementForm")
@DynamicInsert
@DynamicUpdate
@Where(clause = "isDeleted = false")
public class AssetManagementForm
{
    @Id
    @Column(name = "assetMgtID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assetMgtID;

    @Column(name = "dateCreated",
            updatable = false)
    @CreationTimestamp
    private LocalDate dateCreated;

    @Column(name = "dateUpdated")
    @UpdateTimestamp
    private LocalDate dateUpdated;

    @Column(name = "isDeleted",
            nullable = false)
    private Boolean isDeleted = false;

    @OneToOne(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL,
              mappedBy = "assetManagementForm")
    private Assessment assessment;

    @OneToOne(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL,
              mappedBy = "assetManagementForm")
    private Management management;

    @OneToOne(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL,
              mappedBy = "assetManagementForm")
    private Disposition disposition;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "assetManagementForm")
    private ConsultationHistory consultationHistory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientID")
    @JsonBackReference
    private Patient patient;

    public AssetManagementForm() {
    }

    public AssetManagementForm(Integer assetMgtID, LocalDate dateCreated, LocalDate dateUpdated, Assessment assessment, Management management, Disposition disposition) {
        this.assetMgtID = assetMgtID;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.assessment = assessment;
        this.management = management;
        this.disposition = disposition;
    }

    public AssetManagementForm(Integer assetMgtID, LocalDate dateCreated, LocalDate dateUpdated, Boolean isDeleted) {
        this.assetMgtID = assetMgtID;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.isDeleted = isDeleted;
    }

    public Integer getAssetMgtID() {
        return assetMgtID;
    }

    public void setAssetMgtID(Integer assetMgtID) {
        this.assetMgtID = assetMgtID;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public Management getManagement() {
        return management;
    }

    public void setManagement(Management management) {
        this.management = management;
    }

    public Disposition getDisposition() {
        return disposition;
    }

    public void setDisposition(Disposition disposition) {
        this.disposition = disposition;
    }

    public ConsultationHistory getConsultationHistory() {
        return consultationHistory;
    }

    public void setConsultationHistory(ConsultationHistory consultationHistory) {
        this.consultationHistory = consultationHistory;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
