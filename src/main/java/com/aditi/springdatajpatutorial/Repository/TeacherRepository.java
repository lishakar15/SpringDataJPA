package com.aditi.springdatajpatutorial.Repository;

import com.aditi.springdatajpatutorial.Entity.Teacher;
import com.aditi.springdatajpatutorial.model.NameAndAge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    public Teacher findByNameAndAge(String name,Integer age);
}
