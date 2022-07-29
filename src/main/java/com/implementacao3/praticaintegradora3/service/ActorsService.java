package com.implementacao3.praticaintegradora3.service;

import com.implementacao3.praticaintegradora3.model.Actors;
import com.implementacao3.praticaintegradora3.model.Movies;
import com.implementacao3.praticaintegradora3.repository.ActorRepo;
import com.implementacao3.praticaintegradora3.repository.MovieRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class ActorsService implements IActorService{

    @Autowired
    private ActorRepo actorRepo;

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepo repoMovie;

    public List<Actors> findAll(){
        return null;
    }

    @Transactional
    public Actors save(Actors actor)  {
        List<Actors> actorsListDb = (List<Actors>) actorRepo.findAll();
//            for (Actors a: actorsListDb) {
//                if (actor.getFirst_name().equalsIgnoreCase(a.getFirst_name()) &&
//                        actor.getLast_name().equalsIgnoreCase(a.getLast_name())) {
//                    return null;
//                    // throw new Exception("lala");
//                }
//            }
        if (findByFirstNameAndLastName(actor.getFirstName(),actor.getLastName())!=null){
            System.out.println("Ator já existe no banco de dados");
            return null;
        }



        movieService.saveMovie(actor.getFavoriteMovie());
        movieService.saveAll(actor.getMovieList());
        return actorRepo.save(actor);

    }


    @Override
    public Actors findByFirstName(String fistName) {
        return actorRepo.findByFirstName(fistName);
    }

    @Override
    public Actors findByLastName(String fistName) {
        return actorRepo.findByLastName(fistName);
    }

    @Override
    public Actors findByFirstNameAndLastName(String firstName, String lastName) {

        return actorRepo.findByFirstNameAndLastName(firstName,lastName);
    }

  /*  public Actors saveWithMap(Map<String, Object> mapSave){
        Map<String,Object>  = new
    }*/
}
