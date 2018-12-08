package org.zeti.medical.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medical_history")
@DynamicInsert
@DynamicUpdate
@Where(clause = "is_deleted = false")
public class MedicalHistory implements Serializable
{
    @Id
    @Column(name = "medicalHistoryID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicalHistoryID;

    @Column(name = "menstrualHistory",
            length = 100)
    private String menstrualHistory;

    //Family Medical History
    @Column(name = "famMedHistory",
            length = 100)
    private String famMedHistory;

    //    Past Medical History
    @Column(name = "pastMedHistory",
            length = 100)
    private String pastMedHistory;

    //    Family Planning History
    @Column(name = "famPlanHistory",
            length = 100)
    private String famPlanHistory;

    @Column(name = "socialHistory",
            length = 100)
    private String socialHistory;

    @Column(name = "allergyHistory",
            length = 100)
    private String allergyHistory;

    //    Tetanus Toxoid History
    @Column(name = "tetToxHistory",
            length = 100)
    private String tetToxHistory;

    @Column(name = "isDeleted",
            nullable = false)
    private Boolean isDeleted = false;

    @OneToOne(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL)
    @JoinColumn(name = "patientID")
    private Patient patient;

    public MedicalHistory() {
    }

    public MedicalHistory(Integer medicalHistoryID, String menstrualHistory, String famMedHistory, String pastMedHistory, String famPlanHistory, String socialHistory, String allergyHistory, String tetToxHistory) {
        this.medicalHistoryID = medicalHistoryID;
        this.menstrualHistory = menstrualHistory;
        this.famMedHistory = famMedHistory;
        this.pastMedHistory = pastMedHistory;
        this.famPlanHistory = famPlanHistory;
        this.socialHistory = socialHistory;
        this.allergyHistory = allergyHistory;
        this.tetToxHistory = tetToxHistory;
    }

    public Integer getMedicalHistoryID() {
        return medicalHistoryID;
    }

    public void setMedicalHistoryID(Integer medicalHistoryID) {
        this.medicalHistoryID = medicalHistoryID;
    }

    public String getMenstrualHistory() {
        return menstrualHistory;
    }

    public void setMenstrualHistory(String menstrualHistory) {
        this.menstrualHistory = menstrualHistory;
    }

    public String getFamMedHistory() {
        return famMedHistory;
    }

    public void setFamMedHistory(String famMedHistory) {
        this.famMedHistory = famMedHistory;
    }

    public String getPastMedHistory() {
        return pastMedHistory;
    }

    public void setPastMedHistory(String pastMedHistory) {
        this.pastMedHistory = pastMedHistory;
    }

    public String getFamPlanHistory() {
        return famPlanHistory;
    }

    public void setFamPlanHistory(String famPlanHistory) {
        this.famPlanHistory = famPlanHistory;
    }

    public String getSocialHistory() {
        return socialHistory;
    }

    public void setSocialHistory(String socialHistory) {
        this.socialHistory = socialHistory;
    }

    public String getAllergyHistory() {
        return allergyHistory;
    }

    public void setAllergyHistory(String allergyHistory) {
        this.allergyHistory = allergyHistory;
    }

    public String getTetToxHistory() {
        return tetToxHistory;
    }

    public void setTetToxHistory(String tetToxHistory) {
        this.tetToxHistory = tetToxHistory;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
