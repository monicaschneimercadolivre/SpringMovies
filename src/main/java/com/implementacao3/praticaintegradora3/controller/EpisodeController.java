package com.implementacao3.praticaintegradora3.controller;

import com.implementacao3.praticaintegradora3.model.Episodes;
import com.implementacao3.praticaintegradora3.model.Seasons;
import com.implementacao3.praticaintegradora3.repository.EpisodeRepo;
import com.implementacao3.praticaintegradora3.repository.SeasonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episode")
public class EpisodeController {

        @Autowired
        private EpisodeRepo repo;

        @GetMapping("/{id}")
        public ResponseEntity<Episodes> getEpisodeById(@PathVariable long id ){

            return ResponseEntity.ok(repo.findById(id).get());
        }
    }

