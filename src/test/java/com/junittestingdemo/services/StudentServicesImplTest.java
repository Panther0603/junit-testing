package com.junittestingdemo.services;


import com.junittestingdemo.dto.StudentDto;
import com.junittestingdemo.entity.Student;
import com.junittestingdemo.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class StudentServicesImplTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentDto studentDtoMapper;

    @InjectMocks
    private StudentServicesImpl studentServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createStudentTest() {
        // Given data
        StudentDto studentDto = StudentDto.builder()
                .firstName("Mohit")
                .email("mohit@gmail.com")
                .lastName("Kumar")
                .section("11")
                .id(1L)
                .build();

        Student student = Student.builder()
                .firstName("Mohit")
                .lastName("Kumar")
                .email("mohit@gmail.com")
                .section("11")
                .id(1L)
                .build();

        Student savedStudent = Student.builder()
                .firstName("Mohit")
                .lastName("Kumar")
                .email("mohit@gmail.com")
                .section("11")
                .id(1L)
                .build();

        // Stub method calls relevant to the createStudent method

        // Mocking the behavior of studentDtoMapper
        when(studentDtoMapper.mapStudents(studentDto)).thenReturn(student);

        // Mocking the behavior of studentRepository
        when(studentRepository.save(student)).thenReturn(savedStudent);

        when(studentDtoMapper.mapStudentDTO(savedStudent)).thenReturn(studentDto);

        // when
        StudentDto responseDto = studentServices.createStudent(studentDto);

        // then
        Assertions.assertEquals(studentDto.getEmail(), responseDto.getEmail());
        Assertions.assertEquals(studentDto.getFirstName(), responseDto.getFirstName());
        Assertions.assertEquals(studentDto.getLastName(), responseDto.getLastName());
        Assertions.assertEquals(studentDto.getSection(), responseDto.getSection());


        // now we can verify multiple things from this that could be time taken to perform any action kind of thing
        //  we can invoke number of time a method can be called
        verify(studentDtoMapper,times(1)).mapStudents(studentDto);
        verify(studentRepository,times(1)).save(student);
        verify(studentDtoMapper,times(1)).mapStudentDTO(savedStudent);

    }

    @Test
    void deleteStudent() {

        // given
        Long id=2L;
        StudentDto studentDto=StudentDto.builder()
                .firstName("Mohit")
                .lastName("Kumar")
                .email("mohit@gmail.com")
                .id(2L)
                .section("11").build();

        Student student=Student.builder().id(2L)
                .firstName("Mohit")
                .lastName("Kumar")
                .email("mohit@gmail.com")
                .id(2L)
                .section("11").build();



        when(studentRepository.findById(id)).thenReturn(Optional.of(student));
       when(studentDtoMapper.mapStudentDTO(student)).thenReturn(studentDto);

       // when

      StudentDto responseDto=studentServices.deleteStudent(id);

      //then
       Assertions.assertEquals(id,responseDto.getId());

       verify(studentRepository,times(1)).deleteById(id);
        System.out.println("tested");
    }

    @Test
    void getStudentByIdTest() {

        Long id=2L;

        StudentDto studentDto=StudentDto.builder()
                .id(2L)
                .firstName("Mohit")
                .lastName("Kumar")
                .email("mohit@gmail.com")
                .section("11").build();

        Student student=Student.builder().id(2L)
                .firstName("Mohit")
                .lastName("Kumar")
                .email("mohit@gmail.com")
                .section("11").build();

        when(studentDtoMapper.mapStudents(studentDto)).thenReturn(student);
        when(studentRepository.findById(id)).thenReturn(Optional.of(student));

        when(studentDtoMapper.mapStudentDTO(student)).thenReturn(studentDto);

        StudentDto responseDto=studentServices.getStudentDto(id);

        Assertions.assertEquals(studentDto.getFirstName(),responseDto.getFirstName());
        Assertions.assertEquals(studentDto.getLastName(),responseDto.getLastName());
        Assertions.assertEquals(studentDto.getEmail(),responseDto.getEmail());
        Assertions.assertEquals(studentDto.getSection(),responseDto.getSection());

//        --> while verification it will through an error for not running the test cases because this function never used in findById
//        to check comment out
//        verify(studentDtoMapper,times(1)).mapStudents(studentDto);
        verify(studentRepository,times(1)).findById(id);
        verify(studentDtoMapper,times(1)).mapStudentDTO(student);
    }

    @Test
    void findAllStudentTest(){
        List<Student> studentList= new ArrayList<>();
        studentList.add(Student.builder().
                firstName("Mohit").lastName("Kumar").section("11").email("mohit@gmail.com").id(11L).build());

        // setting mock data
        when(studentRepository.findAll()).thenReturn(studentList);

        when(studentDtoMapper.mapStudentDTO(any(Student.class))).thenReturn(StudentDto.builder().firstName("Mohit").lastName("Kumar").section("11").email("mohit@gmail.com").build());
        // when
        List<StudentDto> studentDtos=this.studentServices.findAllStudent();

        Assertions.assertEquals(studentList.size(),studentDtos.size());
        verify(studentRepository,times(1)).findAll();

        System.out.println("matched  "+ studentDtos.size()+" -->"+studentList.size());
    }
}

