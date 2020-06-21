package com.destroyyouth.personsandhobbies;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.destroyyouth.personsandhobbies.commons.dtos.PersonsDTO;
import com.destroyyouth.personsandhobbies.model.Hobbies;
import com.destroyyouth.personsandhobbies.model.Persons;
import com.destroyyouth.personsandhobbies.persistence.IPersonsRepository;
import com.destroyyouth.personsandhobbies.services.IHobbiesService;
import com.destroyyouth.personsandhobbies.services.impl.PersonsService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonsServiceTest {

    @Mock
    private IPersonsRepository personsRepository;
    @Mock
    private IHobbiesService hobbiesService;

    @InjectMocks
    private PersonsService personsService;

    @BeforeEach
    void init() {
        assertNotNull(personsRepository);
        assertNotNull(hobbiesService);
        assertNotNull(personsService);
    }

    @Test
    @DisplayName("Find all registered persons.")
    void findAll() {

        Hobbies hobbie = new Hobbies();
        hobbie.setHobbieId(1);
        hobbie.setName("name");
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(hobbie);

        Persons person = new Persons();
        person.setBirthDate(new Date());
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setHobbies(hobbies);
        person.setMail("mail@mail.com");
        person.setPersonId(1);
        person.setSex("m");
        List<Persons> persons = new ArrayList<>();
        persons.add(person);

        when(personsRepository.findAll()).thenReturn(persons);

        List<PersonsDTO> result = personsService.findAll();

        assertNotNull(result);
        assertNotNull(result.get(0));
    }

    @Test
    @DisplayName("Find person by id")
    void findById() {
        //TODO Complete the PersonsService tests
    }

}