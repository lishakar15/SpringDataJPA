package com.aditi.springdatajpatutorial.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.GeneratedReferenceTypeDelegate;
/**
 * This Class is for OneToOne example
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @SequenceGenerator(
            name ="userSequence",
            sequenceName = "user_seq",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userSequence"
    )
    @Id
    private Integer userId;
    private String password;
    private String role;
}
