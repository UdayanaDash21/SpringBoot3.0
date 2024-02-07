package com.springbootlatest.Spring3.Test.controllers;

import com.springbootlatest.Spring3.Test.exceptions.AgeNotValidException;
import com.springbootlatest.Spring3.Test.records.Student;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ObservationRegistry observationRegistry;

    @RequestMapping("/just")
    public ResponseEntity<Student> testing(){
        var address= """
                SriRamNagar
                Madhupatna
                Cuttack
                Odisha
                India
                75310
                """;

        var student = new Student(1,"Udayana",address);

        System.out.println(student.id());
        return ResponseEntity.ok(student);
    }

    @RequestMapping("after")
    public String test1(HttpServletResponse response){
        return Observation.createNotStarted("after",observationRegistry).observe(()->"this is testing");

//        throw new AgeNotValidException();
    }



}
