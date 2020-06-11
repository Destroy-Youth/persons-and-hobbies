package com.destroyyouth.personsandhobbies.services;

import java.util.List;

import com.destroyyouth.personsandhobbies.commons.dtos.PersonsDTO;

import org.springframework.stereotype.Service;

/**
 * IPersonsService
 */
@Service
public interface IPersonsService extends ISearch<PersonsDTO, Integer> {

    void savePerson(PersonsDTO person);
}