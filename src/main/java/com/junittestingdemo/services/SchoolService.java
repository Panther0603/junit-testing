package com.junittestingdemo.services;

import com.junittestingdemo.dto.SchoolDto;
import com.junittestingdemo.entity.School;

import java.util.List;

public interface SchoolService {

    public List<School> getSchools() ;

    public SchoolDto saveSchool(School school);
}
