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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Actor {

    @SequenceGenerator(
            name = "actor_sequence",
            sequenceName = "actor_sequence"
    )
    @GeneratedValue
    (
            strategy = GenerationType.SEQUENCE,
            generator = "actor_sequence"
    )
    @Id
    private Integer actor_id;
    private String actorName;
    private Integer age;
    @ManyToMany(mappedBy = "actors",cascade = CascadeType.ALL)
    private List<Movie> movies;
}
