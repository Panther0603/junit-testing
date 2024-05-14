package com.junittestingdemo.repository;

import com.junittestingdemo.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;
    @Test
    public  void saveUser(){
        Student student= new Student();
        student.setEmail("mohit@gmail.com");
        student.setFirstName("Mohit");
        student.setLastName("kumar");
        student.setSection("11");

        Student savedStudent=studentRepository.save(student);

        Assertions.assertNotNull(savedStudent);
        System.out.println(savedStudent.getId());
        assertThat(savedStudent.getId()).isGreaterThan(0L);


    }

    @Test
    public  void findByNameTest(){
        Student student= new Student();
        student.setEmail("mohit@gmail.com");
        student.setFirstName("Rohit");
        student.setLastName("kumar");
        student.setSection("11");

        Student student2= new Student();
        student2.setEmail("mohit@gmail.com");
        student2.setFirstName("Mohit");
        student2.setLastName("kumar");
        student2.setSection("11");

        List<Student> students=new ArrayList<>();
        students.add(student);
        students.add(student2);

        // when
        List<Student> savedStudent=studentRepository.saveAll(students);
        //then

        Assertions.assertEquals(students.size(),savedStudent.size());

        //when
        List<Student> getStudentsWithName=studentRepository.findByFirstNameContainingIgnoreCase("Mohitk");
        // then

        Assertions.assertEquals(0,getStudentsWithName.size());

    }


}