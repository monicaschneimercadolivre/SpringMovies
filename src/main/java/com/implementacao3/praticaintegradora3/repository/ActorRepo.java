package com.implementacao3.praticaintegradora3.repository;

import com.implementacao3.praticaintegradora3.model.Actors;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepo extends CrudRepository<Actors, Long> {

    Actors findByFirstName(String firstName);

    Actors findByLastName(String firstName);

    Actors findByFirstNameAndLastName (String firstName, String lastName);

}
