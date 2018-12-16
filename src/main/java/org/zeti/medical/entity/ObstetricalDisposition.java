package org.zeti.medical.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "ObstetricalDisposition")
@DynamicInsert
@DynamicUpdate
public class ObstetricalDisposition
{

    // Specify the constraints of each field

    @Id
    @Column(name = "obsDispositionID",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer obsDispositionID;

    // discharge or referred
    private String dispositionType;

    private String reasonForReferal;

    private String referralHospital;

    private String rmOnDuty;

    private LocalDateTime dispositionDate;



}
