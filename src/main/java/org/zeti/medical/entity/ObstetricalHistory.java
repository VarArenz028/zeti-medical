package org.zeti.medical.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ObstetricalHistory")
@DynamicInsert
@DynamicUpdate
public class ObstetricalHistory implements Serializable
{

    @Id
    @Column(name = "obsHistoryID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer obsHistoryID;

    @Column(name = "gravida",
            length = 20)
    private String gravida;

    @Column(name = "para",
            length = 20)
    private String para;

    @Column(name = "tpal",
            length = 20)
    private String tpal;

    @Column(name = "note",
            length = 512)
    private String note;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
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

    public ObstetricalHistory(Integer obsHistoryID, String gravida, String para, String tpal, String note, Patient patient) {
        this.obsHistoryID = obsHistoryID;
        this.gravida = gravida;
        this.para = para;
        this.tpal = tpal;
        this.note = note;
        this.patient = patient;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
