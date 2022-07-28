package com.implementacao3.praticaintegradora3.service;

import com.implementacao3.praticaintegradora3.model.Movies;
import com.implementacao3.praticaintegradora3.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepo repo;

    public Movies saveMovie (Movies movie){
        return repo.save(movie);
    }

    public List<Movies> saveAll (List<Movies> moviesList){
        return (List<Movies>) repo.saveAll(moviesList);
    }


}
