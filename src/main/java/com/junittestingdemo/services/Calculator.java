package com.junittestingdemo.services;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public  static int  sumTwoNumber(int num1,int num2){
        return  num1+num2;
    }

    public static  int  subTwoNumber(int num1,int num2){
        return  num1-num2;
    }

    public  static int  prodTwoNumber(int num1,int num2){
        return  num1*num2;
    }

    public  static int  divTwoNumber(int num1,int num2){
        return  num1/num2;
    }


}
