package com.implementacao3.praticaintegradora3.service;
import com.implementacao3.praticaintegradora3.model.Actors;
import com.implementacao3.praticaintegradora3.model.Movies;
import com.implementacao3.praticaintegradora3.repository.ActorRepo;
import com.implementacao3.praticaintegradora3.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IMoviesService {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private ActorRepo actorRepo;

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
    public Movies saveMovie (Movies movie) {
        Movies newMovie = movieRepo.findByTitle(movie.getTitle());
       if(newMovie!=null){
            movie.setId(newMovie.getId());
       }else {
           movie.setId(0L);
       }
        for (Actors a : movie.getActorsList()){
           Actors  actor =actorRepo.findByFirstNameAndLastName(a.getFirstName(), a.getLastName());
            if(actor!=null){
                a.setId(actor.getId());
            }else{
                a.setId(0L);
                actorsService.saveActor(a);
            }

        }

        return movieRepo.save(movie);

    /*   Movies newMovie = movieRepo.save(movie);
       movie.setId(newMovie.getId());

       for (Actors a : movie.getActorsList()){
           List<Movies> moviesL = new ArrayList<>();
           moviesL.add(movie);
           a.setMovieList(moviesL);
       }

        for (Actors a : movie.getActorsWhoLikedThisMovies()){

            a.setFavoriteMovie(movie);

        }*/

        /*actorsService.saveAllActors(movie.getActorsWhoLikedThisMovies());
        actorsService.saveAllActors(movie.getActorsList());
        return movieRepo.save(movie);*/
    }
}
