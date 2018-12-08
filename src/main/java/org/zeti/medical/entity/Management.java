package org.zeti.medical.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "management")
@DynamicInsert
@DynamicUpdate
@Where(clause = "is_deleted = false")
public class Management implements Serializable
{
    @Id
    @Column(name = "managementID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer managementID;

    @Column(name = "isDeleted",
            nullable = false)
    private Boolean isDeleted = false;

    @OneToMany(cascade = CascadeType.PERSIST,
               fetch = FetchType.LAZY,
               mappedBy = "management")
    private Set<ActionPlan> actionPlans;

    @OneToOne(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL)
    @JoinColumn(name = "assetMgtID")
    private AssetManagementForm assetManagementForm;

    public Management() {
    }

    public Management(Integer managementID, Set<ActionPlan> actionPlans) {
        this.managementID = managementID;
        this.actionPlans = actionPlans;
    }

    public Integer getManagementID() {
        return managementID;
    }

    public void setManagementID(Integer managementID) {
        this.managementID = managementID;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Set<ActionPlan> getActionPlans() {
        return actionPlans;
    }

    public void setActionPlans(Set<ActionPlan> actionPlans) {
        this.actionPlans = actionPlans;
    }

    public AssetManagementForm getAssetManagementForm() {
        return assetManagementForm;
    }

    public void setAssetManagementForm(AssetManagementForm assetManagementForm) {
        this.assetManagementForm = assetManagementForm;
    }
}
