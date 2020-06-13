package com.destroyyouth.personsandhobbies.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.destroyyouth.personsandhobbies.commons.dtos.HobbiesDTO;
import com.destroyyouth.personsandhobbies.model.Hobbies;
import com.destroyyouth.personsandhobbies.persistence.IHobbiesRepository;
import com.destroyyouth.personsandhobbies.services.IHobbiesService;
import com.destroyyouth.personsandhobbies.utils.ExceptionSuppliers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HobbiesService implements IHobbiesService {

    @Autowired
    private IHobbiesRepository hobbiesRepository;

    @Override
    public List<HobbiesDTO> findAll() {
        return hobbiesRepository.findAll().parallelStream().map(this::hobbiesDTOMapper).collect(Collectors.toList());
    }

    @Override
    public HobbiesDTO findById(Integer id) {

        Hobbies hobbies = hobbiesRepository.findById(id).orElseThrow(ExceptionSuppliers.NOT_FOUND);
        return hobbiesDTOMapper(hobbies);
    }

    @Override
    public HobbiesDTO hobbiesDTOMapper(Hobbies entity) {

        HobbiesDTO dto = new HobbiesDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

}