package com.implementacao3.praticaintegradora3.controller;

import com.implementacao3.praticaintegradora3.model.Actors;
import com.implementacao3.praticaintegradora3.model.Movies;
import com.implementacao3.praticaintegradora3.repository.ActorRepo;
import com.implementacao3.praticaintegradora3.repository.MovieRepo;
import com.implementacao3.praticaintegradora3.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieRepo repo;

    @Autowired
    private MovieService movieService;

    @PostMapping 
    public ResponseEntity<Movies> novoMovie(@RequestBody Movies movie) throws Exception {

        return ResponseEntity.ok(movieService.saveMovie(movie));
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
