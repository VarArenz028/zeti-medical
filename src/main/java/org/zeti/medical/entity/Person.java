package org.zeti.medical.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Person implements Serializable
{
    @Column(name = "lastName",
            nullable = false,
            length = 80)
    @Size(min = 5, max = 80, message = "{validation.name.number.size}")
    private String lastName;

    @Column(name = "firstName",
            nullable = false,
            length = 80)
    @Size(min = 5, max = 80, message = "{validation.name.number.size}")
    private String firstName;

    @Column(name = "middleInitial",
            nullable = true,
            length = 5)
    @Size(min = 1, max = 5, message = "{validation.midinitial.number.size}")
    private String middleInitial;

    @Column(name = "age",
            nullable = false,
            length = 120)

    @PositiveOrZero(message = "{validation.positive.age}")
    private Integer age;

    @Column(name = "birthDate",
            nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Past(message = "{validation.past.birthdate}")
    private LocalDate birthDate;

    public Person() {
    }

    public Person(String lastName, String firstName, String middleInitial, Integer age, LocalDate birthDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.age = age;
        this.birthDate = birthDate;
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

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
