package com.aditi.springdatajpatutorial.Repository;

import com.aditi.springdatajpatutorial.Entity.Games;
import com.aditi.springdatajpatutorial.Entity.Guardian;
import com.aditi.springdatajpatutorial.Entity.Student;
import com.aditi.springdatajpatutorial.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class RepositoryTest {
    @Autowired
    public StudentRepository studentRepository;
    @Autowired
    public GamesRepository gamesRepository;
    @Autowired
    public TeacherRepository teacherRepository;

    @Test
    public void saveStudent() {
        Guardian guardian = new Guardian("dean", "dean@hotmail.com", "9852785102");
        Student s = Student.builder()
                .name("Luna")
                .emailId("LUNA@gmail.com")
                .guardian(guardian)
                .build();
        //Jpa Repository's method
        Student res = studentRepository.save(s);
        System.out.println(res);
    }

    @Test
    public void saveGameDetails() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date releaseDate = sdf.parse("2018-09-23");
        Games g = Games.builder().name("God of War").price(2500).releaseDate(releaseDate).build();
        gamesRepository.save(g);
    }
    @Test
    public void saveTeacher()
    {
        Teacher t = Teacher.builder().name("Mark").subjectExpert("AWS").age(35).build();
        Teacher teacher = teacherRepository.save(t);
        System.out.println(teacher);

    }

    @Test
    public void getGameDetails() {
        List<Games> li = gamesRepository.findGamesByNameContaining("G");
        System.out.println(li.toString());
    }

    @Test
    public void getAllStudents() {
        List<Student> li = studentRepository.findAll();
        System.out.println(li.toString());
    }

    @Test
    public void deleteStudent() {
        studentRepository.deleteById(201);
    }

    @Test
    public void getStudentName() {
        List<Student> li = studentRepository.findByName("Frank");
        System.out.println(li.toString());
    }

    @Test
    public void printNameById() {
        Student student = studentRepository.findStudentById(101);
        System.out.println(student);
    }

    @Test
    public void getMaxIdStudent() {
        studentRepository.findAll();
    }

    @Test
    public void getStudentBetweenIds() {
        List<Student> li = studentRepository.findByIdBetween(101, 103);
        System.out.println(li);
    }

    @Test
    public void getByNameAndGuardianName() {
        List<Student> li = studentRepository.findByNameOrGuardianName("raj", "Dean");
        System.out.println(li.toString());
    }

    @Test
    public void getStudentsIn() {
        List<String> li = new ArrayList<>(Arrays.asList("Frank", "Madhu"));
        List<Student> studentList = studentRepository.findByNameIn(li);
        System.out.println(studentList.toString());
    }
    public void findByIdNotIn()
    {
        List<Student> li =  studentRepository.findByIdNotIn(Arrays.asList(101,102));
        li.forEach(System.out::println);
    }
    @Test
    public void getStudentsDesc() {
        List<Student> li = studentRepository.findByIdGreaterThanOrderByIdDesc(99);
        System.out.println(li.toString());
    }

    @Test
    public void getAllStudentsDesc() {
        List<Student> li = studentRepository.findAllByOrderByIdDesc();
        System.out.println(li.toString());
    }

    //Using Query Annotation methods
    @Test
    public void getStudentUsingName() {
        Student s = studentRepository.getStudentBasedOnName("Frank");
        System.out.println(s.toString());
    }
    @Test
    public void getStudentBetweenId(){
    List<Student> li=  studentRepository.getStudentBetweenIds(101,103);
        System.out.println(li);
    }
    @Test
    public void getStudentWithTheirEmailId(){
        Student s = studentRepository.getStudentByTheirEmailId("madhu@gmail.com");
        System.out.println(s.toString());
    }
    @Test
    public void updateStudentEmailId()
    {
        studentRepository.updateStudentEmailId("madhu@gmail.com",102);
    }

    @Test
    public void getStudentDetailsUsingNative()
    {
        Student s = studentRepository.getStudentDetailsUsingNative("Luna");
        System.out.println(s.toString());
    }
    @Test
    public void getAllStudentsNative()
    {
        List<Student> li = studentRepository.getAllStudentsNative();
        System.out.println(li);
    }

    @Test
    public void getNameUsingNative()
    {
        List<String> li = studentRepository.getNameUsingNative(101);
        for(String str:li)
        {
            System.out.println(str);
        }
    }
    @Test
    public void getStudentNameUsingNativeAndParams()
    {
        Student s = studentRepository.getStudentNameUsingNativeAndParams("madhu@gmail.com","Neha");
        System.out.println(s.toString());
    }

    @Test
    public void insertTeacherData()
    {
        teacherRepository.insertTeacherData(15,"Kenny","Physics",29);
    }



}


