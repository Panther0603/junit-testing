package com.junittestingdemo.services;

import com.junittestingdemo.dto.StudentDto;
import com.junittestingdemo.entity.Student;
import com.junittestingdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServicesImpl implements StudentServices{


    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentDto mapStudentDTO;
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student=mapStudentDTO.mapStudents(studentDto);
           student= this.studentRepository.save(student);
            studentDto=mapStudentDTO.mapStudentDTO(student);
        return studentDto;
    }

    @Override
    public StudentDto deleteStudent(Long id) {
        if(id == null){
            throw  new RuntimeException("Id can't be null");
        }
        Optional<Student> optional = this.studentRepository.findById(id);
        this.studentRepository.deleteById(id);
        return  mapStudentDTO.mapStudentDTO(optional.orElseGet(Student::new));
    }



    @Override
    public StudentDto getStudentDto(Long id) {
        if(id == null){
            throw  new RuntimeException("Id can't be null");
        }
        Optional<Student> optional = this.studentRepository.findById(id);
        return  mapStudentDTO.mapStudentDTO(optional.orElseGet(Student::new));
    }

    @Override
    public List<StudentDto> findAllStudent(){

        return  this.studentRepository.findAll().stream().
                map(mapStudentDTO::mapStudentDTO).
                collect(Collectors.toList());
    }
}
