package com.destroyyouth.personsandhobbies.web;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import com.destroyyouth.personsandhobbies.commons.dtos.HobbiesDTO;
import com.destroyyouth.personsandhobbies.services.IHobbiesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HobbiesController {

    @Autowired
    private IHobbiesService hobbiesService;

    @GetMapping(value = "/v1/hobbies", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HobbiesDTO>> findAll() {
        List<HobbiesDTO> hobbiesDTOs = hobbiesService.findAll();
        return ResponseEntity.ok().body(hobbiesDTOs);
    }

    @GetMapping(value = "/v1/hobbies/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<HobbiesDTO> findById(@PathVariable(name = "id") Integer id) {
        HobbiesDTO hobbiesDTOs = hobbiesService.findById(id);
        return ResponseEntity.ok().body(hobbiesDTOs);
    }

}