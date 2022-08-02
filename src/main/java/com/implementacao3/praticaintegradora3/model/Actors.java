package com.implementacao3.praticaintegradora3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Actors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date created_at;

    private Date updated_at;

    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;

    private Double rating;

    @ManyToMany (mappedBy = "actorsList")
    @JsonIgnoreProperties({"actorsList", "actorsWhoLikedThisMovies"})
    private List<Movies> movieList;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="favorite_movie_id")
    @JsonIgnoreProperties ({"actorsWhoLikedThisMovies", "actorsList"})
    private Movies favoriteMovie;

}
