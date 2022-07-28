package com.implementacao3.praticaintegradora3.repository;

import com.implementacao3.praticaintegradora3.model.Seasons;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepo extends CrudRepository<Seasons, Long> {
}
