package com.junittestingdemo.dto;

import com.junittestingdemo.controller.S;
import com.junittestingdemo.entity.School;
import lombok.*;
import org.springframework.stereotype.Component;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class SchoolDto {

    private String name;
    private String location;


    public  SchoolDto mapEntityToDto(School school) {
        return SchoolDto.builder().name(school.getName()).location(school.getLocation()).build();
    }
}
