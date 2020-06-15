package com.destroyyouth.personsandhobbies;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.destroyyouth.personsandhobbies.commons.dtos.HobbiesDTO;
import com.destroyyouth.personsandhobbies.model.Hobbies;
import com.destroyyouth.personsandhobbies.persistence.IHobbiesRepository;
import com.destroyyouth.personsandhobbies.services.impl.HobbiesService;

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

}