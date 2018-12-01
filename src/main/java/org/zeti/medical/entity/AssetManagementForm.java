package org.zeti.medical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ActionPlan")
@DynamicInsert
@DynamicUpdate
public class AssetManagementForm implements Serializable
{
    @Id
    @Column(name = "assetMgtID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assetMgtID;

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
            mappedBy = "assetManagementForm",
            cascade = CascadeType.ALL)
    private Assessment assessment;

    @OneToOne(fetch = FetchType.LAZY,
            mappedBy = "assetManagementForm",
            cascade = CascadeType.ALL)
    private Management management;

    @OneToOne(fetch = FetchType.LAZY,
            mappedBy = "assetManagementForm",
            cascade = CascadeType.ALL)
    private Disposition disposition;

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
}
