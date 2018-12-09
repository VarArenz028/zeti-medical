package org.zeti.medical.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "ConsultationHistory")
@DynamicInsert
@DynamicUpdate
public class ConsultationHistory
{
    @Id
    @Column(name = "consultID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "{validation.field.null}")
    private Integer consultID;

    @Column(name = "lastName",
            nullable = false,
            length = 50)
    @NotNull(message = "{validation.field.null}")
    @Size(max = 50, message = "Maximum size is 50")
    private String lastName;

    @Column(name = "firstName",
            nullable = false,
            length = 50)
    @NotNull(message = "{validation.field.null}")
    @Size(max = 50, message = "Maximum size is 50")
    private String firstName;

    @Column(name = "role",
            nullable = false,
            length = 15)
    @NotNull(message = "{validation.field.null}")
    @Size(max = 15, message = "Maximum size is 15")
    private String role;

    @Column(name = "dateConsulted")
    @CreationTimestamp
    private LocalDateTime dateConsulted;

    @OneToOne(fetch = FetchType.LAZY,
              cascade = CascadeType.ALL)
    @JoinColumn(name = "assetMgtID")
    private AssetManagementForm assetManagementForm;

    public ConsultationHistory() {
    }

    public Integer getConsultID() {
        return consultID;
    }

    public void setConsultID(Integer consultID) {
        this.consultID = consultID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getDateConsulted() {
        return dateConsulted;
    }

    public void setDateConsulted(LocalDateTime dateConsulted) {
        this.dateConsulted = dateConsulted;
    }

    public AssetManagementForm getAssetManagementForm() {
        return assetManagementForm;
    }

    public void setAssetManagementForm(AssetManagementForm assetManagementForm) {
        this.assetManagementForm = assetManagementForm;
    }
}
