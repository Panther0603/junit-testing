package com.junittestingdemo.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssertDemoTest {

    @Test
    @Disabled
    public  void test1(){
        String name =new String("Mohit");
        String expectedName = new String("Mohit");

        // we will see this test case will get failed because it is checking the object
        // reference if it same then testcase will get passed otherwise failed
        Assertions.assertSame(expectedName,name);
    }

    @Test
    public  void test2(){
        String name ="Mohit";
        String expectedName="Mohit";

        // in this I have used the assertSame but still test case will be passed because both are
        // referring to the same reference point in the constant pool
        //
        Assertions.assertSame(expectedName,name,"I'm checking different different  assertion method");
    }

    @Test
    public  void test3(){
        String name =new String("Mohit");
        String expectedName= new String("Mohit");

        // assertEquals used to check the value of the object not the reference of the object
        Assertions.assertEquals(expectedName,name);
    }

    @Test
    public  void test4(){
        List<Integer> actualList= Arrays.asList(1,2,3,4,5);
        List<Integer>  expectedList=Arrays.asList(1,2,3,4,5);
        Assertions.assertIterableEquals(expectedList,actualList,"this is checking all the values are at the same index or not");
    }

    @Test
    public void test5(){

        System.out.println(" this for checking the exception type is expected or not");
        Assertions.assertThrows(RuntimeException.class,() ->{
            System.out.println("If other than the Run time exception test case will get passed");
            throw new RuntimeException("This is run time time exception test");

        });
    }
}
