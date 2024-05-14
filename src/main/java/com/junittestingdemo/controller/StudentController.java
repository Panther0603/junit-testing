package com.junittestingdemo.controller;

import com.junittestingdemo.dto.StudentDto;
import com.junittestingdemo.services.RedisServices;
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

    @Autowired
    RedisServices redisServices;

    @PostMapping("/save")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
        return ResponseEntity.ok(studentServices.createStudent(studentDto));
    }


    @GetMapping("/byId")
    public ResponseEntity<StudentDto> getStudentById(@RequestParam Long id){
        StudentDto studentDto= redisServices.getRedisData("student_"+id,StudentDto.class);
        if(studentDto!=null){
            return ResponseEntity.ok(studentDto);
        }else{
            studentDto=studentServices.getStudentDto(id);
            redisServices.setRedisData("student_"+id,studentDto,120l);
             return ResponseEntity.ok(studentDto);
        }

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
