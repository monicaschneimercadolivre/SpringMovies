package com.implementacao3.praticaintegradora3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Episodes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date created_at;

    private Date updated_at;

    private int number;

    private Double rating;

    private Date release_date;

    @Column(length = 10)
    private String title;

    @ManyToOne
    @JoinColumn(name="season_id") // essa é a chave estrangeira
    @JsonIgnoreProperties("episodes")
    private Seasons seasonsId;

}
