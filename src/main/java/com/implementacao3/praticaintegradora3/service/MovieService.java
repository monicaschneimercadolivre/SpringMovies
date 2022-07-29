package com.implementacao3.praticaintegradora3.service;
import com.implementacao3.praticaintegradora3.model.Movies;
import com.implementacao3.praticaintegradora3.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovieService implements IMoviesService {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private ActorsService actorsService;


    @Override
    public Movies findByMovieTitle(String title) {
        return movieRepo.findByTitle(title);
    }

    @Override
    public List<Movies> saveAllMovies(List<Movies> moviesList) {
        return (List<Movies>) movieRepo.saveAll(moviesList);
    }

    @Override
    @Transactional
    public Movies saveMovie (Movies movie) throws Exception {
        if(findByMovieTitle(movie.getTitle())!=null){
            throw new Exception("O movie já existe");
        }


        actorsService.saveAllActors(movie.getActorsWhoLikedThisMovies());
        actorsService.saveAllActors(movie.getActorsList());
        return  movieRepo.save(movie);
    }

}
