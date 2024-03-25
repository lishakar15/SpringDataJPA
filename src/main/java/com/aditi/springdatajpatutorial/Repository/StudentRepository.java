package com.aditi.springdatajpatutorial.Repository;
import com.aditi.springdatajpatutorial.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
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
    @Query("Select s from Student s where s.name =?1")
    public Student getStudentBasedOnName(String name);
    @Query("select s from Student s where s.id between ?1 and ?2" )
    public List<Student>  getStudentBetweenIds(Integer id1, Integer id2);

}