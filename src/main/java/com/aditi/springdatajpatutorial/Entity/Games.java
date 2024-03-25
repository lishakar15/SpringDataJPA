package com.aditi.springdatajpatutorial.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="video_games",
        uniqueConstraints = @UniqueConstraint(
        name = "unique_game_name",
        columnNames = "game_name"
))
@Builder
public class Games {

    @SequenceGenerator(name ="game_sequence",initialValue = 101,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "game_sequence")
    @Id
    private int id;
    @Column(name ="game_name")
    private String name;
    private Date releaseDate;
    private int price;

}
