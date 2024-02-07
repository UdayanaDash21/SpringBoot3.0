package com.springbootlatest.Spring3.Test.controllers;

import com.springbootlatest.Spring3.Test.exceptions.AgeNotValidException;
import com.springbootlatest.Spring3.Test.services.VoteService;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @Autowired
    private ObservationRegistry observationRegistry;

    @PostMapping
    public ResponseEntity<?> vote(@RequestParam("age") int age) {

        if(age > 18){
            this.voteService.vote(age);
            return Observation.createNotStarted("vote",observationRegistry)
                    .observe(()->ResponseEntity.ok("Voted"));
        }
       throw new AgeNotValidException("Age not Valid !!");

    }

}
