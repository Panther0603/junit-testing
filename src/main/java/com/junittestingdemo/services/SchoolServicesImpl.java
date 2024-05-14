package com.junittestingdemo.services;

import com.junittestingdemo.dto.SchoolDto;
import com.junittestingdemo.entity.School;
import com.junittestingdemo.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolServicesImpl implements SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    @Autowired
    SchoolDto schoolDto;
    @Override
    public SchoolDto saveSchool(School school) {
        school=  schoolRepository.save(school);
        SchoolDto schoolDto1=schoolDto.mapEntityToDto(school);
        return  schoolDto1;
    }

}
