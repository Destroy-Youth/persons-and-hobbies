package com.destroyyouth.personsandhobbies.services;

import com.destroyyouth.personsandhobbies.commons.dtos.HobbiesDTO;
import com.destroyyouth.personsandhobbies.model.Hobbies;
import com.destroyyouth.personsandhobbies.services.ISearch;

public interface IHobbiesService extends ISearch<HobbiesDTO, Integer> {

    public HobbiesDTO hobbiesDTOMapper(Hobbies entity);

}