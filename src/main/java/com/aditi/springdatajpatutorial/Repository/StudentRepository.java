package com.aditi.springdatajpatutorial.Repository;
import com.aditi.springdatajpatutorial.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    public List<Student> findByName(String name);
    public Student findStudentById(Integer id);
    public List<Student> findByIdBetween(Integer i,Integer j);
    public List<Student> findByNameOrGuardianName(String name,String guardianName);
    public List<Student> findByNameIn(List<String> li);
    public List<Student> findByIdGreaterThanOrderByIdDesc(Integer i);
    public List<Student> findAllByOrderByIdDesc();
    public List<Student> findStudentByName(String name);
    //JPA Query
    @Query("Select s from Student s where s.name =?1")
    public Student getStudentBasedOnName(String name);
    @Query("select s from Student s where s.id between ?1 and ?2" )
    public List<Student>  getStudentBetweenIds(Integer id1, Integer id2);
    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentByTheirEmailId(String emailId);
    @Transactional
    @Modifying
    @Query("update Student s set s.emailId =?1 where s.id =?2")
    public void updateStudentEmailId(String emailId,Integer id);
    //Native Queries
    @Query(value = "select * from student_info where name =?1",nativeQuery = true)
    public Student getStudentDetailsUsingNative(String name);
    @Query(value = "select * from student_info",nativeQuery = true)//Get all the rows from the table
    public List<Student> getAllStudentsNative();

}