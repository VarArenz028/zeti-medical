package org.zeti.medical.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Management")
@DynamicInsert
@DynamicUpdate
public class Management implements Serializable
{
    @Id
    @Column(name = "managementID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer managementID;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private AssetManagementForm assetManagementForm;

    @OneToMany(mappedBy = "management",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<ActionPlan> actionPlans;

    public Management() {
    }

    public Management(Integer managementID, Set<ActionPlan> actionPlans) {
        this.managementID = managementID;
        this.actionPlans = actionPlans;
    }

    public Management(Integer managementID, AssetManagementForm assetManagementForm, Set<ActionPlan> actionPlans) {
        this.managementID = managementID;
        this.assetManagementForm = assetManagementForm;
        this.actionPlans = actionPlans;
    }

    public Integer getManagementID() {
        return managementID;
    }

    public void setManagementID(Integer managementID) {
        this.managementID = managementID;
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
