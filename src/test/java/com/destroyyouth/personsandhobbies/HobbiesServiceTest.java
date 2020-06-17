package com.destroyyouth.personsandhobbies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.destroyyouth.personsandhobbies.commons.dtos.HobbiesDTO;
import com.destroyyouth.personsandhobbies.model.Hobbies;
import com.destroyyouth.personsandhobbies.persistence.IHobbiesRepository;
import com.destroyyouth.personsandhobbies.services.impl.HobbiesService;
import com.destroyyouth.personsandhobbies.utils.Messages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HobbiesServiceTest {

    @InjectMocks
    private HobbiesService hobbiesService;
    @Mock
    private IHobbiesRepository hobbiesRepository;

    @BeforeEach
    void init() {
        assertNotNull(hobbiesRepository);
        assertNotNull(hobbiesService);
    }

    @Test
    @DisplayName("Find all hobbies.")
    void findAllHobbies() {

        Hobbies hobbie = new Hobbies();
        hobbie.setHobbieId(1);
        hobbie.setName("name");
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(hobbie);

        when(hobbiesRepository.findAll()).thenReturn(hobbies);

        List<HobbiesDTO> result = hobbiesService.findAll();
        assertNotNull(result);
        assertNotNull(result.get(0));
    }

    @Test
    @DisplayName("Find hobbie by id.")
    void findOne() {

        Hobbies hobbie = new Hobbies();
        hobbie.setHobbieId(1);
        hobbie.setName("name");

        when(hobbiesRepository.findById(anyInt())).thenReturn(Optional.of(hobbie));

        HobbiesDTO result = hobbiesService.findById(1);
        assertNotNull(result);
        assertNotNull(result.getName());
    }

    @Test
    @DisplayName("Find hobbie by id, id doesn't exists.")
    void findOneDoesntExists() {

        when(hobbiesRepository.findById(anyInt())).thenThrow(new NoSuchElementException(Messages.NOT_FOUND));

        NoSuchElementException result = assertThrows(NoSuchElementException.class, () -> hobbiesService.findById(1));

        assertNotNull(result);
        assertEquals(Messages.NOT_FOUND, result.getMessage());
    }

}