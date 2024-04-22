package com.junittestingdemo.repository;

import com.junittestingdemo.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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


}