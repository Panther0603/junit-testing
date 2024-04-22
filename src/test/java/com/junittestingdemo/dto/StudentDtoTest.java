package com.junittestingdemo.dto;

import com.junittestingdemo.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class StudentDtoTest {
    StudentDto studentDto =null;
    Student student=null;


    private  StudentDto mapStudentDTO;

    @BeforeEach
    void setUp() {

        studentDto = new StudentDto();
        student= new Student();
        mapStudentDTO= new StudentDto();
    }

    @Test
    void mapStudentDTO() {

        studentDto = StudentDto.builder().firstName("Mohit").email("mohit@email.com").lastName("kumar").section("11").build();
        student = mapStudentDTO.mapStudents(studentDto);
        student.setId(21l);
        Assertions.assertEquals(studentDto.getFirstName(),student.getFirstName());
        Assertions.assertEquals(studentDto.getLastName(),student.getLastName());
        Assertions.assertEquals(studentDto.getEmail(),student.getEmail());
        Assertions.assertEquals(studentDto.getSection(),student.getSection());
        Assertions.assertNotNull(student.getId());
    }

    @Test
    void mapStudents() {
        student = Student.builder().firstName("Mohit").email("mohit@email.com").lastName("kumar").section("11").build();
        studentDto = mapStudentDTO.mapStudentDTO(student);

        Assertions.assertNotNull(student.getFirstName(),"Student first name can't be null");
        Assertions.assertEquals(student.getFirstName(),studentDto.getFirstName());
        Assertions.assertEquals(student.getLastName(),studentDto.getLastName());
        Assertions.assertEquals(student.getEmail(),studentDto.getEmail());
        Assertions.assertEquals(student.getSection(),studentDto.getSection());

    }
}