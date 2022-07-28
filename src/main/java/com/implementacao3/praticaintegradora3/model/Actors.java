package com.implementacao3.praticaintegradora3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Actors {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private Date created_at;

    private Date updated_at;

    @Column(length = 20)
    private String first_name;

    @Column(length = 30)
    private String last_name;

    private Double rating;

    @ManyToMany (mappedBy = "actorsList",cascade = CascadeType.REFRESH)

    @JsonIgnoreProperties({"actorsList", "actorsWhoLikedThisMovies"})
    private List<Movies> movieList;

    @ManyToOne (cascade = CascadeType.REFRESH)
    @JoinColumn(name="favorite_movie_id") // essa é a chave estrangeira
    @JsonIgnoreProperties ({"actorsWhoLikedThisMovies", "actorsList"})
    private Movies favoriteMovie;
}
