package org.zeti.medical.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ActionPlan")
@DynamicInsert
@DynamicUpdate
public class ActionPlan implements Serializable
{
    @Id
    @Column(name = "actionPlanID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actionPlanID;

    @Column(name = "actionName",
            length = 100)
    private String actionName;

    @Column(name = "action",
            length = 50)
    private String action;

    @ManyToOne(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    @JsonBackReference
    private Management management;

    public ActionPlan() {
    }

    public ActionPlan(Integer actionPlanID, String actionName, String action) {
        this.actionPlanID = actionPlanID;
        this.actionName = actionName;
        this.action = action;
    }

    public ActionPlan(Integer actionPlanID, String actionName, String action, Management management) {
        this.actionPlanID = actionPlanID;
        this.actionName = actionName;
        this.action = action;
        this.management = management;
    }

    public Integer getActionPlanID() {
        return actionPlanID;
    }

    public void setActionPlanID(Integer actionPlanID) {
        this.actionPlanID = actionPlanID;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Management getManagement() {
        return management;
    }

    public void setManagement(Management management) {
        this.management = management;
    }
}
