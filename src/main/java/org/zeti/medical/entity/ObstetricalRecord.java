package org.zeti.medical.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ObstetricalRecord")
@DynamicInsert
@DynamicUpdate
public class ObstetricalRecord implements Serializable
{

    // Specify the constraints of each field

    @Id
    @Column(name = "obsRecordID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer obsRecordID;

    @Column(name = "labor",
            length = 50)
    private String labor;

    //Procedure Done During Labor
    @Column(name = "proDoneDuringLabor",
            length = 50)
    private String proDoneDuringLabor;

    @Column(name = "amnioticFluid",
            length = 50)
    private String amnioticFluid;

    @Column(name = "mannerOfDelivery",
            length = 50)
    private String mannerOfDelivery;

    @Column(name = "episiotomy",
            length = 50)
    private String episiotomy;

    @Column(name = "perinealLaceration",
            length = 50)
    private String perinealLaceration;

    @Column(name = "placentalDelivery",
            length = 50)
    private String placentalDelivery;

    @Column(name = "typeOfPlacenta",
            length = 50)
    private String typeOfPlacenta;

    //Gross Placental Abnormalities
    @Column(name = "grossPlaclAbnorm",
            length = 50)
    private String grossPlaclAbnorm;

    @Column(name = "cordAbnormalities",
            length = 50)
    private String cordAbnormalities;

    @Column(name = "postpartumProblems",
            length = 50)
    private String postpartumProblems;

    // Condition of Mother After Delivery
    @Column(name = "condOfMotherAftDelivery",
            length = 50)
    private String condOfMotherAftDelivery;

    @Column(name = "vitalSigns",
            length = 50)
    private String vitalSigns;

    @Column(name = "anesthesia",
            length = 50)
    private String anesthesia;

    @Column(name = "gender",
            length = 50)
    private String gender;

    @Column(name = "weight",
            length = 50)
    private Integer weight;

    @Column(name = "length",
            length = 50)
    private Integer length;

    @Column(name = "apgarScore",
            length = 50)
    private Integer apgarScore;

    @Column(name = "fetalOutcome",
            length = 50)
    private String fetalOutcome;

    @Column(name = "dateAndTimeOfDelivery",
            length = 50)
    private LocalDateTime dateAndTimeOfDelivery;

    @Column(name = "attending",
            length = 50)
    private String attending;

    @Column(name = "finalDiagnosis",
            length = 50)
    private String finalDiagnosis;

    @Column(name = "isDeleted",
            nullable = false)
    private Boolean isDeleted = false;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PatientID")
    @JsonBackReference
    private Patient patient;

    public ObstetricalRecord() {
    }

    public ObstetricalRecord(Integer obsRecordID, String labor, String proDoneDuringLabor, String amnioticFluid, String mannerOfDelivery, String episiotomy, String perinealLaceration, String placentalDelivery, String typeOfPlacenta, String grossPlaclAbnorm, String cordAbnormalities, String postpartumProblems, String condOfMotherAftDelivery, String vitalSigns, String anesthesia, String gender, Integer weight, Integer length, Integer apgarScore, String fetalOutcome, LocalDateTime dateAndTimeOfDelivery, String attending, String finalDiagnosis) {
        this.obsRecordID = obsRecordID;
        this.labor = labor;
        this.proDoneDuringLabor = proDoneDuringLabor;
        this.amnioticFluid = amnioticFluid;
        this.mannerOfDelivery = mannerOfDelivery;
        this.episiotomy = episiotomy;
        this.perinealLaceration = perinealLaceration;
        this.placentalDelivery = placentalDelivery;
        this.typeOfPlacenta = typeOfPlacenta;
        this.grossPlaclAbnorm = grossPlaclAbnorm;
        this.cordAbnormalities = cordAbnormalities;
        this.postpartumProblems = postpartumProblems;
        this.condOfMotherAftDelivery = condOfMotherAftDelivery;
        this.vitalSigns = vitalSigns;
        this.anesthesia = anesthesia;
        this.gender = gender;
        this.weight = weight;
        this.length = length;
        this.apgarScore = apgarScore;
        this.fetalOutcome = fetalOutcome;
        this.dateAndTimeOfDelivery = dateAndTimeOfDelivery;
        this.attending = attending;
        this.finalDiagnosis = finalDiagnosis;
    }

    public ObstetricalRecord(String labor, String proDoneDuringLabor, String amnioticFluid, String mannerOfDelivery, String episiotomy, String perinealLaceration, String placentalDelivery, String typeOfPlacenta, String grossPlaclAbnorm, String cordAbnormalities, String postpartumProblems, String condOfMotherAftDelivery, String vitalSigns, String anesthesia, String gender, Integer weight, Integer length, Integer apgarScore, String fetalOutcome, LocalDateTime dateAndTimeOfDelivery, String attending, String finalDiagnosis) {
        this.labor = labor;
        this.proDoneDuringLabor = proDoneDuringLabor;
        this.amnioticFluid = amnioticFluid;
        this.mannerOfDelivery = mannerOfDelivery;
        this.episiotomy = episiotomy;
        this.perinealLaceration = perinealLaceration;
        this.placentalDelivery = placentalDelivery;
        this.typeOfPlacenta = typeOfPlacenta;
        this.grossPlaclAbnorm = grossPlaclAbnorm;
        this.cordAbnormalities = cordAbnormalities;
        this.postpartumProblems = postpartumProblems;
        this.condOfMotherAftDelivery = condOfMotherAftDelivery;
        this.vitalSigns = vitalSigns;
        this.anesthesia = anesthesia;
        this.gender = gender;
        this.weight = weight;
        this.length = length;
        this.apgarScore = apgarScore;
        this.fetalOutcome = fetalOutcome;
        this.dateAndTimeOfDelivery = dateAndTimeOfDelivery;
        this.attending = attending;
        this.finalDiagnosis = finalDiagnosis;
    }

    public ObstetricalRecord(Integer obsRecordID, String labor, String proDoneDuringLabor, String amnioticFluid, String mannerOfDelivery, String episiotomy, String perinealLaceration, String placentalDelivery, String typeOfPlacenta, String grossPlaclAbnorm, String cordAbnormalities, String postpartumProblems, String condOfMotherAftDelivery, String vitalSigns, String anesthesia, String gender, Integer weight, Integer length, Integer apgarScore, String fetalOutcome, LocalDateTime dateAndTimeOfDelivery, String attending, String finalDiagnosis, Patient patient) {
        this.obsRecordID = obsRecordID;
        this.labor = labor;
        this.proDoneDuringLabor = proDoneDuringLabor;
        this.amnioticFluid = amnioticFluid;
        this.mannerOfDelivery = mannerOfDelivery;
        this.episiotomy = episiotomy;
        this.perinealLaceration = perinealLaceration;
        this.placentalDelivery = placentalDelivery;
        this.typeOfPlacenta = typeOfPlacenta;
        this.grossPlaclAbnorm = grossPlaclAbnorm;
        this.cordAbnormalities = cordAbnormalities;
        this.postpartumProblems = postpartumProblems;
        this.condOfMotherAftDelivery = condOfMotherAftDelivery;
        this.vitalSigns = vitalSigns;
        this.anesthesia = anesthesia;
        this.gender = gender;
        this.weight = weight;
        this.length = length;
        this.apgarScore = apgarScore;
        this.fetalOutcome = fetalOutcome;
        this.dateAndTimeOfDelivery = dateAndTimeOfDelivery;
        this.attending = attending;
        this.finalDiagnosis = finalDiagnosis;
        this.patient = patient;
    }

    public ObstetricalRecord(Integer obsRecordID, String labor, String proDoneDuringLabor, String amnioticFluid, String mannerOfDelivery, String episiotomy, String perinealLaceration, String placentalDelivery, String typeOfPlacenta, String grossPlaclAbnorm, String cordAbnormalities, String postpartumProblems, String condOfMotherAftDelivery, String vitalSigns, String anesthesia, String gender, Integer weight, Integer length, Integer apgarScore, String fetalOutcome, LocalDateTime dateAndTimeOfDelivery, String attending, String finalDiagnosis, Boolean isDeleted, Patient patient) {
        this.obsRecordID = obsRecordID;
        this.labor = labor;
        this.proDoneDuringLabor = proDoneDuringLabor;
        this.amnioticFluid = amnioticFluid;
        this.mannerOfDelivery = mannerOfDelivery;
        this.episiotomy = episiotomy;
        this.perinealLaceration = perinealLaceration;
        this.placentalDelivery = placentalDelivery;
        this.typeOfPlacenta = typeOfPlacenta;
        this.grossPlaclAbnorm = grossPlaclAbnorm;
        this.cordAbnormalities = cordAbnormalities;
        this.postpartumProblems = postpartumProblems;
        this.condOfMotherAftDelivery = condOfMotherAftDelivery;
        this.vitalSigns = vitalSigns;
        this.anesthesia = anesthesia;
        this.gender = gender;
        this.weight = weight;
        this.length = length;
        this.apgarScore = apgarScore;
        this.fetalOutcome = fetalOutcome;
        this.dateAndTimeOfDelivery = dateAndTimeOfDelivery;
        this.attending = attending;
        this.finalDiagnosis = finalDiagnosis;
        this.isDeleted = isDeleted;
        this.patient = patient;
    }

    public Integer getObsRecordID() {
        return obsRecordID;
    }

    public void setObsRecordID(Integer obsRecordID) {
        this.obsRecordID = obsRecordID;
    }

    public String getLabor() {
        return labor;
    }

    public void setLabor(String labor) {
        this.labor = labor;
    }

    public String getProDoneDuringLabor() {
        return proDoneDuringLabor;
    }

    public void setProDoneDuringLabor(String proDoneDuringLabor) {
        this.proDoneDuringLabor = proDoneDuringLabor;
    }

    public String getAmnioticFluid() {
        return amnioticFluid;
    }

    public void setAmnioticFluid(String amnioticFluid) {
        this.amnioticFluid = amnioticFluid;
    }

    public String getMannerOfDelivery() {
        return mannerOfDelivery;
    }

    public void setMannerOfDelivery(String mannerOfDelivery) {
        this.mannerOfDelivery = mannerOfDelivery;
    }

    public String getEpisiotomy() {
        return episiotomy;
    }

    public void setEpisiotomy(String episiotomy) {
        this.episiotomy = episiotomy;
    }

    public String getPerinealLaceration() {
        return perinealLaceration;
    }

    public void setPerinealLaceration(String perinealLaceration) {
        this.perinealLaceration = perinealLaceration;
    }

    public String getPlacentalDelivery() {
        return placentalDelivery;
    }

    public void setPlacentalDelivery(String placentalDelivery) {
        this.placentalDelivery = placentalDelivery;
    }

    public String getTypeOfPlacenta() {
        return typeOfPlacenta;
    }

    public void setTypeOfPlacenta(String typeOfPlacenta) {
        this.typeOfPlacenta = typeOfPlacenta;
    }

    public String getGrossPlaclAbnorm() {
        return grossPlaclAbnorm;
    }

    public void setGrossPlaclAbnorm(String grossPlaclAbnorm) {
        this.grossPlaclAbnorm = grossPlaclAbnorm;
    }

    public String getCordAbnormalities() {
        return cordAbnormalities;
    }

    public void setCordAbnormalities(String cordAbnormalities) {
        this.cordAbnormalities = cordAbnormalities;
    }

    public String getPostpartumProblems() {
        return postpartumProblems;
    }

    public void setPostpartumProblems(String postpartumProblems) {
        this.postpartumProblems = postpartumProblems;
    }

    public String getCondOfMotherAftDelivery() {
        return condOfMotherAftDelivery;
    }

    public void setCondOfMotherAftDelivery(String condOfMotherAftDelivery) {
        this.condOfMotherAftDelivery = condOfMotherAftDelivery;
    }

    public String getVitalSigns() {
        return vitalSigns;
    }

    public void setVitalSigns(String vitalSigns) {
        this.vitalSigns = vitalSigns;
    }

    public String getAnesthesia() {
        return anesthesia;
    }

    public void setAnesthesia(String anesthesia) {
        this.anesthesia = anesthesia;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getApgarScore() {
        return apgarScore;
    }

    public void setApgarScore(Integer apgarScore) {
        this.apgarScore = apgarScore;
    }

    public String getFetalOutcome() {
        return fetalOutcome;
    }

    public void setFetalOutcome(String fetalOutcome) {
        this.fetalOutcome = fetalOutcome;
    }

    public LocalDateTime getDateAndTimeOfDelivery() {
        return dateAndTimeOfDelivery;
    }

    public void setDateAndTimeOfDelivery(LocalDateTime dateAndTimeOfDelivery) {
        this.dateAndTimeOfDelivery = dateAndTimeOfDelivery;
    }

    public String getAttending() {
        return attending;
    }

    public void setAttending(String attending) {
        this.attending = attending;
    }

    public String getFinalDiagnosis() {
        return finalDiagnosis;
    }

    public void setFinalDiagnosis(String finalDiagnosis) {
        this.finalDiagnosis = finalDiagnosis;
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
