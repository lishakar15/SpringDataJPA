package com.aditi.springdatajpatutorial.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * This Class is for ManyToMany example
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @SequenceGenerator(
            name = "movie_seq",
            sequenceName = "movie_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_seq"
    )
    @Id
    private Integer movie_id;
    private String movieName;
    private String genere;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Actor> actors;

}
