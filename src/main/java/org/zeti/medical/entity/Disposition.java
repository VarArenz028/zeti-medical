package org.zeti.medical.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MedicalHistory")
@DynamicInsert
@DynamicUpdate
public class Disposition implements Serializable
{

    @Id
    @Column(name = "dispositionID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dispositionID;

    @Column(name = "dispositionNote",
            length = 512)
    private String dispositionNote;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private AssetManagementForm assetManagementForm;

    public Disposition() {
    }

    public Disposition(Integer dispositionID, String dispositionNote) {
        this.dispositionID = dispositionID;
        this.dispositionNote = dispositionNote;
    }

    public Disposition(Integer dispositionID, String dispositionNote, AssetManagementForm assetManagementForm) {
        this.dispositionID = dispositionID;
        this.dispositionNote = dispositionNote;
        this.assetManagementForm = assetManagementForm;
    }

    public Integer getDispositionID() {
        return dispositionID;
    }

    public void setDispositionID(Integer dispositionID) {
        this.dispositionID = dispositionID;
    }

    public String getDispositionNote() {
        return dispositionNote;
    }

    public void setDispositionNote(String dispositionNote) {
        this.dispositionNote = dispositionNote;
    }

    public AssetManagementForm getAssetManagementForm() {
        return assetManagementForm;
    }

    public void setAssetManagementForm(AssetManagementForm assetManagementForm) {
        this.assetManagementForm = assetManagementForm;
    }
}
