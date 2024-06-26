package com.aditi.springdatajpatutorial.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.lang.reflect.GenericArrayType;
import java.util.List;

/**
 * This Class is for OneToMany example
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="parent_details")
public class Parent {
    @SequenceGenerator(
            name = "parent_sequence",
            sequenceName = "parent_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
            generator = "parent_sequence"
    )
    @Id
    private Integer parentId;
    private String parentName;
    private Integer parentAge;
    @OneToMany(mappedBy = "parent",cascade = CascadeType.REMOVE)
    private List<Children> children;
}
