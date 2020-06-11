package com.destroyyouth.personsandhobbies.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.destroyyouth.personsandhobbies.model.Persons;

/**
 * PersonsRepository
 */
@Repository
public interface IPersonsRepository extends JpaRepository<Persons, Integer> {

}