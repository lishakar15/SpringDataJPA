package com.aditi.springdatajpatutorial.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This Class is for OneToOne example
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfile {
    @Id
    @SequenceGenerator(
            name ="userProfileSequence",
            sequenceName = "user_profile_seq",
            initialValue = 101,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userProfileSequence"
    )
    private Integer profileId;
    private String name;
    private Integer age;
    private String country;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;

}
