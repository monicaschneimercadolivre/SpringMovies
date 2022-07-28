package com.implementacao3.praticaintegradora3.repository;

import com.implementacao3.praticaintegradora3.model.Episodes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepo extends CrudRepository<Episodes, Long> {
}
