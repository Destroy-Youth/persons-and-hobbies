package com.destroyyouth.personsandhobbies.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

/**
 * Persons
 */
@Entity
public class Persons implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 9065228481115363903L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer personId;
    private String firstName;
    private String lastName;
    @Column(name = "birthdate")
    private Date birthDate;
    private String mail;
    private String sex;
    @ManyToMany
    @JoinTable(name = "persons_hobbies", uniqueConstraints = @UniqueConstraint(columnNames = { "person_id",
            "hobbie_id" }), joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "hobbie_id"))
    private List<Hobbies> hobbies;
    @ManyToOne()
    @JoinColumn(name = "address_id")
    private Addresses address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public List<Hobbies> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobbies> hobbies) {
        this.hobbies = hobbies;
    }

}