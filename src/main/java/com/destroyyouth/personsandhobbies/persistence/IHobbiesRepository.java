package com.destroyyouth.personsandhobbies.persistence;

import com.destroyyouth.personsandhobbies.model.Hobbies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHobbiesRepository extends JpaRepository<Hobbies, Integer> {

}