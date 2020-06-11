package com.destroyyouth.personsandhobbies.services;

import java.util.List;

import com.destroyyouth.personsandhobbies.commons.dtos.PersonsDTO;

import org.springframework.stereotype.Service;

/**
 * IPersonsService
 */
@Service
public interface IPersonsService {

    List<PersonsDTO> findAll();

    void savePerson(PersonsDTO person);
}