package com.junittestingdemo.controller;

import com.junittestingdemo.dto.SchoolDto;
import com.junittestingdemo.entity.School;
import com.junittestingdemo.services.SchoolServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;


@RestController
public class S {

    @Autowired
    SchoolServicesImpl schoolServices;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseEntity<SchoolDto> saveSchool(@RequestBody School school){
        SchoolDto school1=schoolServices.saveSchool(school);
        return  ResponseEntity.ok(school1);
    }
}
