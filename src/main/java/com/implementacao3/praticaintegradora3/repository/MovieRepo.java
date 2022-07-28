package com.implementacao3.praticaintegradora3.repository;

import com.implementacao3.praticaintegradora3.model.Actors;
import com.implementacao3.praticaintegradora3.model.Movies;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movies, Long> {

}
