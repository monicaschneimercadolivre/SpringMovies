package com.implementacao3.praticaintegradora3.service;

import com.implementacao3.praticaintegradora3.model.Actors;
import com.implementacao3.praticaintegradora3.model.Movies;
import com.implementacao3.praticaintegradora3.repository.ActorRepo;
import com.implementacao3.praticaintegradora3.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ActorsService {
    @Autowired
    private ActorRepo repoActor;

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepo repoMovie;

    public List<Actors> findAll(){
        return null;
    }

    @Transactional
    public Actors save (Actors actor)  {
        List<Actors> actorsListDb = (List<Actors>) repoActor.findAll();
            for (Actors a: actorsListDb) {
                if (actor.getFirst_name().equalsIgnoreCase(a.getFirst_name()) &&
                        actor.getLast_name().equalsIgnoreCase(a.getLast_name())) {
                    return null;
                    // throw new Exception("lala");
                }
            }

                movieService.saveAll(actor.getMovieList());
                movieService.saveMovie(actor.getFavoriteMovie());
                return repoActor.save(actor);

    }
}
