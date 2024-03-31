package com.aditi.springdatajpatutorial.Repository;

import com.aditi.springdatajpatutorial.Entity.Teacher;
import com.aditi.springdatajpatutorial.model.NameAndAge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    public Teacher findByNameAndAge(String name,Integer age);
    @Transactional
    @Modifying
    @Query(value= "insert into teacher (id,name,subject_name,age) values(?1,?2,?3,?4)",nativeQuery =true)
    public void insertTeacherData(Integer id,String name,String subjectName,Integer age);
}
