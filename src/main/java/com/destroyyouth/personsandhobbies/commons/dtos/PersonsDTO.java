package com.destroyyouth.personsandhobbies.commons.dtos;

import java.util.List;

/**
 * PersonsDTO
 */
public class PersonsDTO extends BaseDTO {

    /**
     *
     */
    private static final long serialVersionUID = 8324321294578528875L;

    private String firstName;
    private String lastName;
    private String birthDate;
    private String mail;
    private String sex;
    private List<HobbiesDTO> hobbies;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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

    public List<HobbiesDTO> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<HobbiesDTO> hobbies) {
        this.hobbies = hobbies;
    }

}