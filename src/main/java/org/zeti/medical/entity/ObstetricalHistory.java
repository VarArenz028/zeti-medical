package org.zeti.medical.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "obstetrical_history")
@DynamicInsert
@DynamicUpdate
@Where(clause = "is_deleted = false")
public class ObstetricalHistory implements Serializable
{

    @Id
    @Column(name = "obsHistoryID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer obsHistoryID;

    @Column(name = "gravida",
            length = 20)
    @Size(max = 20, message = "{validation.ob.number.size}")
    private String gravida;

    @Column(name = "para",
            length = 20)
    @Size(max = 20, message = "{validation.ob.number.size}")
    private String para;

    @Column(name = "tpal",
            length = 20)
    @Size(max = 20, message = "{validation.ob.number.size}")
    private String tpal;

    @Column(name = "note",
            length = 512)
    @Size(max = 512, message = "{validation.note.number.size}")
    private String note;

    @Column(name = "isDeleted",
            nullable = false)
    private Boolean isDeleted = false;

    @OneToOne(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL)
    @JoinColumn(name = "patientID")
    private Patient patient;

    public ObstetricalHistory() {
    }

    public ObstetricalHistory(Integer obsHistoryID, String gravida, String para, String tpal, String note) {
        this.obsHistoryID = obsHistoryID;
        this.gravida = gravida;
        this.para = para;
        this.tpal = tpal;
        this.note = note;
    }

    public Integer getObsHistoryID() {
        return obsHistoryID;
    }

    public void setObsHistoryID(Integer obsHistoryID) {
        this.obsHistoryID = obsHistoryID;
    }

    public String getGravida() {
        return gravida;
    }

    public void setGravida(String gravida) {
        this.gravida = gravida;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getTpal() {
        return tpal;
    }

    public void setTpal(String tpal) {
        this.tpal = tpal;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
