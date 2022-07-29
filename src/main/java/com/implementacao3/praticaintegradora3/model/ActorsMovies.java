package com.implementacao3.praticaintegradora3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name = "actors_movies")
public class ActorsMovies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idActorsMovies;

    @OneToMany (mappedBy = "idMoviesActors",cascade = CascadeType.REFRESH)
    private List<Movies> idMovie;

    @OneToMany (mappedBy = "idActorsMovies",cascade = CascadeType.REFRESH)
    private List<Actors> idActor;
}
