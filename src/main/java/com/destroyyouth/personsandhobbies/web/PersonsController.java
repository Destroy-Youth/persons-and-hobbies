package com.destroyyouth.personsandhobbies.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import com.destroyyouth.personsandhobbies.commons.dtos.PersonsDTO;
import com.destroyyouth.personsandhobbies.model.Persons;
import com.destroyyouth.personsandhobbies.services.IPersonsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * PersonsController
 */
@RestController
@CrossOrigin
public class PersonsController {

    @Autowired
    private IPersonsService personsService;

    @GetMapping(consumes = ALL_VALUE, produces = APPLICATION_JSON_VALUE, value = "/v1/persons")
    public ResponseEntity<List<PersonsDTO>> persons() {
        return new ResponseEntity<>(personsService.findAll(), HttpStatus.OK);
    }

    @PostMapping(consumes = ALL_VALUE, produces = APPLICATION_JSON_VALUE, value = "/v1/persons")
    public ResponseEntity person(@RequestBody PersonsDTO person) {
        personsService.savePerson(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
