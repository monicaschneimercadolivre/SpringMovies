package com.implementacao3.praticaintegradora3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@Entity

public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date created_at;

    private Date updated_at;

    private Date release_date;

    @Column(length = 20, nullable = false)
    private String title;

    private Double rating;

    private int awards;

    private Integer length;

    @ManyToMany (cascade = CascadeType.REFRESH)
    @JoinTable(name= "actor_movie",
            joinColumns = @JoinColumn(name="movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="actor_id", referencedColumnName = "id")
    )
    @JsonIgnoreProperties({"movieList","favoriteMovie"})
    private List<Actors> actorsList;

    @OneToMany (mappedBy = "favoriteMovie",cascade = CascadeType.REFRESH)
    @JsonIgnoreProperties ({"favoriteMovie", "movieList"})
    private List<Actors> actorsWhoLikedThisMovies;




}
