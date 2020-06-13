package com.destroyyouth.personsandhobbies.web;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import com.destroyyouth.personsandhobbies.commons.dtos.PersonsDTO;
import com.destroyyouth.personsandhobbies.services.IPersonsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * PersonsController
 */
@RestController
@CrossOrigin
public class PersonsController {

    @Autowired
    private IPersonsService personsService;

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/v1/persons")
    public ResponseEntity<List<PersonsDTO>> findAll() {
        return new ResponseEntity<>(personsService.findAll(), HttpStatus.OK);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/v1/persons/{id}")
    public ResponseEntity<PersonsDTO> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(personsService.findById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE, value = "/v1/persons")
    public ResponseEntity person(@RequestBody PersonsDTO person) {
        personsService.savePerson(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
