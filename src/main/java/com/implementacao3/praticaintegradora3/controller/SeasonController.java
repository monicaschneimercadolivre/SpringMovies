package com.implementacao3.praticaintegradora3.controller;

import com.implementacao3.praticaintegradora3.model.Movies;
import com.implementacao3.praticaintegradora3.model.Seasons;
import com.implementacao3.praticaintegradora3.repository.MovieRepo;
import com.implementacao3.praticaintegradora3.repository.SeasonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/season")
public class SeasonController {

    @Autowired
    private SeasonRepo repo;

    @GetMapping("/{id}")
    public ResponseEntity<Seasons> getSeasonById(@PathVariable long id ){

        return ResponseEntity.ok(repo.findById(id).get());
    }
}
