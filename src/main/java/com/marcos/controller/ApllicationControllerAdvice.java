package com.marcos.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.marcos.exception.RecordNotFoundException;

@RestControllerAdvice 
public class ApllicationControllerAdvice {
   @ExceptionHandler(RecordNotFoundException.class)
   @ResponseStatus (code = org.springframework.http.HttpStatus.NOT_FOUND)
   public String handleNotFoundException(RecordNotFoundException ex){
        return ex.getMessage();
    }
}
// 