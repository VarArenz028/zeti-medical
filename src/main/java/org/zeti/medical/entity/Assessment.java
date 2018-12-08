package org.zeti.medical.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "assessment")
@DynamicInsert
@DynamicUpdate
@Where(clause = "is_deleted = false")
public class Assessment implements Serializable
{

    @Id
    @Column(name = "assessmentID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assessmentID;

    @Column(name = "wt",
            length = 50)
    @Size(min = 2, max = 50, message = "{validation.assessment.number.size}")
    private String wt;

    @Column(name = "fh",
            length = 50)
    @Size(max = 50, message = "{validation.assessment.number.size}")
    private String fh;

    @Column(name = "fht",
            length = 50)
    @Size(max = 50, message = "{validation.assessment.number.size}")
    private String fht;

    @Column(name = "temp",
            length = 50)
    @Size(max = 50, message = "{validation.assessment.number.size}")
    private String temp;

    @Column(name = "rr",
            length = 50)
    @Size(max = 50, message = "{validation.assessment.number.size}")
    private String rr;

    @Column(name = "pr",
            length = 50)
    @Size(max = 50, message = "{validation.assessment.number.size}")
    private String pr;

    @Column(name = "sig",
            length = 50)
    @Size(max = 50, message = "{validation.assessment.number.size}")
    private String sig;

    @Column(name = "note",
            length = 512)
    @Size(max = 512, message = "{validation.note.number.size}")
    private String note;

    @Column(name = "isDeleted",
            nullable = false)
    private Boolean isDeleted = false;

    @OneToOne(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL)
    @JoinColumn(name = "assetMgtID")
    private AssetManagementForm assetManagementForm;

    public Assessment() {
    }

    public Assessment(Integer assessmentID, String wt, String fh, String fht, String temp, String rr, String pr, String sig, String note) {
        this.assessmentID = assessmentID;
        this.wt = wt;
        this.fh = fh;
        this.fht = fht;
        this.temp = temp;
        this.rr = rr;
        this.pr = pr;
        this.sig = sig;
        this.note = note;
    }

    public Integer getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(Integer assessmentID) {
        this.assessmentID = assessmentID;
    }

    public String getWt() {
        return wt;
    }

    public void setWt(String wt) {
        this.wt = wt;
    }

    public String getFh() {
        return fh;
    }

    public void setFh(String fh) {
        this.fh = fh;
    }

    public String getFht() {
        return fht;
    }

    public void setFht(String fht) {
        this.fht = fht;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getRr() {
        return rr;
    }

    public void setRr(String rr) {
        this.rr = rr;
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public AssetManagementForm getAssetManagementForm() {
        return assetManagementForm;
    }

    public void setAssetManagementForm(AssetManagementForm assetManagementForm) {
        this.assetManagementForm = assetManagementForm;
    }
}
