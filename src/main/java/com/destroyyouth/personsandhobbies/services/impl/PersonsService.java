package com.destroyyouth.personsandhobbies.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.destroyyouth.personsandhobbies.commons.dtos.PersonsDTO;
import com.destroyyouth.personsandhobbies.model.Hobbies;
import com.destroyyouth.personsandhobbies.model.Persons;
import com.destroyyouth.personsandhobbies.persistence.IPersonsRepository;
import com.destroyyouth.personsandhobbies.services.IHobbiesService;
import com.destroyyouth.personsandhobbies.services.IPersonsService;
import com.destroyyouth.personsandhobbies.utils.ExceptionSuppliers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * PersonsService
 */
@Service
public class PersonsService implements IPersonsService {

    @Autowired
    private IPersonsRepository personsRepository;
    @Autowired
    private IHobbiesService hobbiesService;

    @Override
    public List<PersonsDTO> findAll() {
        List<Persons> persons = personsRepository.findAll();

        List<PersonsDTO> personsTO = persons.stream().map(this::personsDTOMapper).collect(Collectors.toList());

        return personsTO;
    }

    @Override
    public void savePerson(PersonsDTO personTO) {
        Persons newPerson = personsMapper(personTO);
        personsRepository.save(newPerson);
    }

    private PersonsDTO personsDTOMapper(Persons person) {
        PersonsDTO personDTO = new PersonsDTO();

        personDTO.setId(person.getPersonId());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        personDTO.setBirthDate(person.getBirthDate().toString());
        personDTO.setMail(person.getMail());
        personDTO.setSex(person.getSex());
        personDTO.setHobbies(person.getHobbies().parallelStream().map(hobbiesService::hobbiesDTOMapper)
                .collect(Collectors.toList()));

        return personDTO;
    }

    private Persons personsMapper(PersonsDTO personTO) {
        Persons person = new Persons();
        Date birthDate = new Date();
        try {
            birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(personTO.getBirthDate());
        } catch (ParseException e) {
            // TODO Cutom exception invalid date format
            e.printStackTrace();
        }

        person.setFirstName(personTO.getFirstName());
        person.setLastName(personTO.getLastName());
        person.setBirthDate(birthDate);
        person.setMail(personTO.getMail());
        person.setSex(personTO.getSex());

        if (!ObjectUtils.isEmpty(personTO.getHobbies())) {
            List<Hobbies> hobbies = personTO.getHobbies().stream().map(hobbieTO -> {
                Hobbies hobbie = new Hobbies();
                hobbie.setName(hobbieTO.getName());
                return hobbie;
            }).collect(Collectors.toList());
            person.setHobbies(hobbies);
        }

        return person;
    }

    @Override
    public PersonsDTO findById(Integer id) {
        Persons person = personsRepository.findById(id).orElseThrow(ExceptionSuppliers.NOT_FOUND);
        return personsDTOMapper(person);
    }

}