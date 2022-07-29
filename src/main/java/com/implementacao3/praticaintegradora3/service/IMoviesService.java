package com.implementacao3.praticaintegradora3.service;

import com.implementacao3.praticaintegradora3.model.Movies;

import java.util.List;

public interface IMoviesService {

    Movies saveMovie (Movies movie) throws Exception;

    List<Movies> saveAllMovies (List<Movies> moviesList);

    Movies findByMovieTitle (String movie);

}
