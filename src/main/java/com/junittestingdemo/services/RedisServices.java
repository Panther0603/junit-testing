package com.junittestingdemo.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.junittestingdemo.controller.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServices {



    @Autowired
    RedisTemplate redisTemplate;

    public <T> T getRedisData(String key,Class<T> mapperClass){

        try {
            Object redisData=redisTemplate.opsForValue().get(key);
            ObjectMapper objectMapper=new ObjectMapper();
            return objectMapper.readValue(redisData.toString(),mapperClass);
        } catch (Exception e) {

           return  null;
        }
    }

    public void setRedisData(String key,Object mapperClass,long timeToBePresent){
        try {
            System.out.println("serting datat ");
            ObjectMapper objectMapper= new ObjectMapper();
            String jsonValue=objectMapper.writeValueAsString(mapperClass);
           redisTemplate.opsForValue().set(key,jsonValue,timeToBePresent, TimeUnit.SECONDS);
            System.out.println("data setted for key  "+key);
            System.out.println(jsonValue);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
