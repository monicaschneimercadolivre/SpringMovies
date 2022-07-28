package com.implementacao3.praticaintegradora3.controller;

import com.implementacao3.praticaintegradora3.model.Actors;
import com.implementacao3.praticaintegradora3.model.Movies;
import com.implementacao3.praticaintegradora3.repository.ActorRepo;
import com.implementacao3.praticaintegradora3.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieRepo repo;

    @PostMapping 
    public ResponseEntity<Movies> novoMovie(@RequestBody Movies movie){

        return ResponseEntity.ok(repo.save(movie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movies> getMoviesById (@PathVariable long id){
        return ResponseEntity.ok(repo.findById(id).get());
    }

    @GetMapping("/list")
    public ResponseEntity<List<Movies>> getAllMovies (){

        return  ResponseEntity.ok((List<Movies>) repo.findAll());
    }

}
