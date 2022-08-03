package com.implementacao3.praticaintegradora3.service;

import com.implementacao3.praticaintegradora3.exceptions.IdNotFoundException;
import com.implementacao3.praticaintegradora3.model.Actors;
import com.implementacao3.praticaintegradora3.repository.ActorRepo;
import com.implementacao3.praticaintegradora3.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ActorsService implements IActorService{

    @Autowired
    private ActorRepo actorRepo;

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepo movieRepo;


    public Actors getById(long id) {
        return actorRepo.findById(id).orElseThrow(()->new IdNotFoundException("Id não encontrado"));
    }

    @Override
    public Actors findByFirstNameAndLastName(String firstName, String lastName) {
        return actorRepo.findByFirstNameAndLastName(firstName, lastName);
    }

    public Actors saveActor(Actors actor) {
        //  List<Actors> actorsListDb = (List<Actors>) actorRepo.findAll();
//            for (Actors a: actorsListDb) {
//                if (actor.getFirst_name().equalsIgnoreCase(a.getFirst_name()) &&
//                        actor.getLast_name().equalsIgnoreCase(a.getLast_name())) {
//                    return null;
//                    // throw new Exception("lala");
//                }
//            }

        Actors newActor = findByFirstNameAndLastName(actor.getFirstName(), actor.getLastName());
        if (newActor != null) {
            actor.setId(newActor.getId());
        }
            return actorRepo.save(actor);
            //Actors newActor = actorRepo.save(actor);
            // actor.setId(newActor.getId());
        /*movieRepo.save(actor.getFavoriteMovie());
        movieService.saveAllMovies(actor.getMovieList());*/



    }
}
