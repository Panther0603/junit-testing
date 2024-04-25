package com.junittestingdemo.controller;

import com.junittestingdemo.dto.StudentDto;
import com.junittestingdemo.services.StudentServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServicesImpl studentServices;

    @PostMapping("/save")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
        return ResponseEntity.ok(studentServices.createStudent(studentDto));
    }


    @GetMapping("/byId")
    public ResponseEntity<StudentDto> getStudentById(@RequestParam Long id){
        return ResponseEntity.ok(studentServices.getStudentDto(id));
    }


    @DeleteMapping("/byId")
    public ResponseEntity<StudentDto> deleteStudentById(@RequestParam Long id){
        return ResponseEntity.ok(studentServices.deleteStudent(id));
    }


    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentServices.findAllStudent());
    }


}
