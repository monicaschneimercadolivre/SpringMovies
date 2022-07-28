package com.implementacao3.praticaintegradora3.controller;

import com.implementacao3.praticaintegradora3.model.Actors;
import com.implementacao3.praticaintegradora3.model.Movies;
import com.implementacao3.praticaintegradora3.repository.ActorRepo;
import com.implementacao3.praticaintegradora3.service.ActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    private ActorRepo repo;

    @Autowired
    private ActorsService service;

    @PostMapping
    public ResponseEntity<Actors> novoActor(@RequestBody Actors actor)  {
        return ResponseEntity.ok(service.save(actor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actors> getActorsById (@PathVariable long id){
        return ResponseEntity.ok(repo.findById(id).get());
    }

    @GetMapping("/list")
    public ResponseEntity<List<Actors>> getAllActors (){

        return  ResponseEntity.ok((List<Actors>) repo.findAll());
    }
}
