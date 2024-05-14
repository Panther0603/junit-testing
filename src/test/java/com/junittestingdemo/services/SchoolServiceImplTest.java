package com.junittestingdemo.services;


import com.junittestingdemo.dto.SchoolDto;
import com.junittestingdemo.entity.School;
import com.junittestingdemo.repository.SchoolRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class SchoolServiceImplTest {

    @Mock
    School schoolMock;

    @Mock
    SchoolDto schoolDto;

    @Mock
    SchoolRepository schoolRepository;

    @InjectMocks
    SchoolServicesImpl schoolServices;


    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test

    public void saveSchoolTest(){

        // created school
        School school = School.builder().id(11L).name("GB SSC").location("Mandolin").build();
        School savedSchool = School.builder().id(11L).name("GB SSC").location("Mandolin").build();
        SchoolDto response = SchoolDto.builder().name("GB SSC").location("Mandolin").build();

        when(schoolRepository.save(school)).thenReturn(savedSchool);
        when(schoolDto.mapEntityToDto(savedSchool)).thenReturn(response);

        // Call the method under test
        SchoolDto result = schoolServices.saveSchool(school);

        // Verify that the save method of schoolRepository is called once with the school object
        verify(schoolRepository, times(1)).save(school);

        // Assert that the result is the same as the savedSchool
        Assertions.assertEquals(result.getLocation(), savedSchool.getLocation());
        Assertions.assertEquals(result.getName(), savedSchool.getName());

    }
}
