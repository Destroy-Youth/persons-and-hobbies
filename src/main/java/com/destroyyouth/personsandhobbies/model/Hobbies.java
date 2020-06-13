package com.destroyyouth.personsandhobbies.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Hobbies
 */
@Entity
public class Hobbies implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4819239186181304922L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer hobbieId;
    private String name;
    @ManyToMany(mappedBy = "hobbies")
    private List<Persons> persons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHobbieId() {
        return hobbieId;
    }

    public void setHobbieId(Integer hobbieId) {
        this.hobbieId = hobbieId;
    }

    public List<Persons> getPersons() {
        return persons;
    }

    public void setPersons(List<Persons> persons) {
        this.persons = persons;
    }

}