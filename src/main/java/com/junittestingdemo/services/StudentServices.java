package com.junittestingdemo.services;

import com.junittestingdemo.dto.StudentDto;

import java.util.List;

public interface StudentServices {

    public  StudentDto createStudent(StudentDto studentDto) ;
    public StudentDto deleteStudent(Long id);
    public StudentDto getStudentDto(Long id);
    public List<StudentDto> findAllStudent();
}
