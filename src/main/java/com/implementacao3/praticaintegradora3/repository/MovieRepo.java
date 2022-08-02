package com.implementacao3.praticaintegradora3.repository;

import com.implementacao3.praticaintegradora3.model.Movies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepo extends CrudRepository<Movies, Long> {

   Movies findByTitle(String title);


}
