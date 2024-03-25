package com.aditi.springdatajpatutorial.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="student_info",
    uniqueConstraints = @UniqueConstraint(
            name = "emailId_unique",
            columnNames = "student_email"
    )
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @SequenceGenerator(
            name ="student_sequence",
            sequenceName = "student_sequence",
            initialValue = 100,
            allocationSize =1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Integer id;
    private String name;
    @Column(name ="student_email", nullable = false)
    private String emailId;
    @Embedded
    private Guardian guardian;

}
