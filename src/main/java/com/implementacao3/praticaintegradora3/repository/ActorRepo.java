package com.implementacao3.praticaintegradora3.repository;

import com.implementacao3.praticaintegradora3.model.Actors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepo extends CrudRepository<Actors, Long> {


    Actors findByFirstNameAndLastName (String firstName, String lastName);



}
