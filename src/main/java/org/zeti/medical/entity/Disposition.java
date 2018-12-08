package org.zeti.medical.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "disposition")
@DynamicInsert
@DynamicUpdate
@Where(clause = "is_deleted = false")
public class Disposition implements Serializable
{

    @Id
    @Column(name = "dispositionID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dispositionID;

    @Column(name = "dispositionNote",
            length = 512)
    @Size(max = 512, message = "{validation.note.number.size}")
    private String dispositionNote;

    @Column(name = "isDeleted",
            nullable = false)
    private Boolean isDeleted = false;

    @OneToOne(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL)
    @JoinColumn(name = "assetMgtID")
    private AssetManagementForm assetManagementForm;

    public Disposition() {
    }

    public Disposition(Integer dispositionID, String dispositionNote) {
        this.dispositionID = dispositionID;
        this.dispositionNote = dispositionNote;
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
