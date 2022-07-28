package com.implementacao3.praticaintegradora3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Seasons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date created_at;

    private Date updated_at;

    private Date end_date;

    private int number;

    private Date release_date;

    private String title;

    @OneToMany (mappedBy = "seasonsId")//
    @JsonIgnoreProperties ("seasonsId")
    private List<Episodes> episodesList;
}
