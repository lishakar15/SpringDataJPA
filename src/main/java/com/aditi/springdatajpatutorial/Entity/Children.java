package com.aditi.springdatajpatutorial.Entity;

import com.aditi.springdatajpatutorial.Entity.Parent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This Class is for ManyToOne example
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="children_details")
public class Children {

    @SequenceGenerator(
            name="child_sequence",
            sequenceName = "child_sequence",
            initialValue = 100,
            allocationSize = 2

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "child_sequence"
    )
    @Id
    private Integer childId;
    private String childName;
    private Integer childAge;
    @ManyToOne
    private Parent parent;
}
