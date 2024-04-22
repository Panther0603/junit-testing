package com.junittestingdemo.services;

import org.junit.jupiter.api.*;

public class CalculatorServiceTestJUint5 {


    // it will get execute before all the method just after the initialization of the class
    @BeforeAll
    public   static void beforeAllTestMethod(){
        System.out.println("I will get executed before all of you -->>> ");
    }

    @BeforeEach
    public  void beforeEachTestMethod(){
        System.out.println("I will get executed before each method");
    }


    @Test
    @Timeout(1)  //--> in this time out it takes input in the seconds
    public  void sumTwoNumbersTest(){

        System.out.println("Sum test executed");
       int actualResult= Calculator.sumTwoNumber(12,56);
       int expectedResult=68;
       try {
           Thread.sleep(1);
       }catch (Exception e){
           e.printStackTrace();
       }

        Assertions.assertEquals(expectedResult,actualResult,"Your test case is failed for the Sum");
    }

    @Test
    @Disabled
    public  void subTwoNumbersTest(){
        int actualResult= Calculator.subTwoNumber(12,10);
        int expectedResult=2;
        Assertions.assertEquals(expectedResult,actualResult,"Your test case is failed for the Sub");

    }


    @Test
    public  void prodTwoNumbersTest(){
        int actualResult= Calculator.prodTwoNumber(12,10);
        int expectedResult=120;
        Assertions.assertEquals(expectedResult,actualResult,"Your test case is failed for the Prod");

    }
    @Test
    public  void divTwoNumbersTest(){
        int actualResult= Calculator.divTwoNumber(12,56);
        int expectedResult=0;
        Assertions.assertEquals(expectedResult,actualResult,"Your test case is failed for the Division");

    }


    @AfterAll
    public static void afterAllTestMethod(){
        System.out.println("I am like a slow turtle who wants to rest and come at last after all");
    }

    @AfterEach
    public  void afterEachMethod(){
        System.out.println("I will get printed after each method \n \n");
    }


}
