package com.springbootlatest.Spring3.Test.exceptions;

public class AgeNotValidException extends RuntimeException{

    public AgeNotValidException(){

    }

    public AgeNotValidException(String message){
        super(message);
    }

}

