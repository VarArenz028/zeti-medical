package org.zeti.medical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.validation.annotation.Validated;
import org.zeti.medical.validation.ValidPassword;
import org.zeti.medical.validation.ValidUsername;
import org.zeti.medical.validation.group.UserAccountGroup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "UserAccount")
@DynamicInsert
@DynamicUpdate
@Where(clause = "isDeleted = false")
@JsonPropertyOrder({"userID", "username", "role", "active", "isDeleted", "dateCreated", "dateUpdated",
                    "lastName", "firstName", "middleInitial", "age", "birthDate"})
public class UserAccount extends Person implements Serializable
{

    @Id
    @Column(name = "userID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    @Column(name = "username",
            nullable = false,
            length = 50)
    @Size(max = 50, message = "Maximum size is 50")
    @NotNull(message = "${validation.field.null}")
    @ValidUsername(message = "Username already exist")
    private String username;

    @Column(name = "password",
            nullable = false,
            length = 50)
    @Size(max = 50, message = "Maximum size is 50")
    @NotNull(message = "${validation.field.null}")
    @ValidPassword(message = "Password already exist")
    private String password;

    @Column(name = "role",
            nullable = false,
            length = 15)
    @Size(max = 15, message = "Maximum size is 15")
    @NotNull(message = "${validation.field.null}")
    private String role;

    @Column(name = "active",
            nullable = false)
    @NotNull(message = "${validation.field.null}")
    private Boolean active = true;

    @Column(name = "isDeleted",
            nullable = false)
    @NotNull(message = "${validation.field.null}")
    private Boolean isDeleted = false;

    @Column(name = "dateCreated",
            updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @CreationTimestamp
    private LocalDate dateCreated;

    @Column(name = "dateUpdated")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @UpdateTimestamp
    private LocalDate dateUpdated;

    public UserAccount() {
    }

    /*
        Field excluded
            password
     */

    public UserAccount(Integer userID, String username, String role, Boolean active, Boolean isDeleted, LocalDate dateCreated, LocalDate dateUpdated) {
        this.userID = userID;
        this.username = username;
        this.role = role;
        this.active = active;
        this.isDeleted = isDeleted;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public UserAccount(String lastName, String firstName, String middleInitial, Integer age, LocalDate birthDate, Integer userID, @Size(max = 50, message = "Maximum size is 50") @NotNull(message = "${validation.field.null}") String username, @Size(max = 15, message = "Maximum size is 15") @NotNull(message = "${validation.field.null}") String role, @NotNull(message = "${validation.field.null}") Boolean active, LocalDate dateCreated, LocalDate dateUpdated) {
        super(lastName, firstName, middleInitial, age, birthDate);
        this.userID = userID;
        this.username = username;
        this.role = role;
        this.active = active;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
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
}
