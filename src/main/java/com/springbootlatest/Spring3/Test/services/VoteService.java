package com.springbootlatest.Spring3.Test.services;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
    public void vote(int age){
        System.out.println("Your vote is Resgistered");
    }
}
