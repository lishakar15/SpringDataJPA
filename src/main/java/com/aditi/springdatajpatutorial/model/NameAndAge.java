package com.aditi.springdatajpatutorial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameAndAge {
    private String name;
    private String age;
}
