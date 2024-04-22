package com.junittestingdemo.dto;

import com.junittestingdemo.entity.Student;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class StudentDto {


    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String section;

    public  StudentDto  mapStudentDTO(Student student){

        StudentDto studentDto= new StudentDto();
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setSection(student.getSection());
        studentDto.setEmail(student.getEmail());

        return  studentDto;
    }

    public  Student  mapStudents(StudentDto studentDto){

        Student student= new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setSection(studentDto.getSection());
        student.setEmail(studentDto.getEmail());

        return  student;
    }





}
