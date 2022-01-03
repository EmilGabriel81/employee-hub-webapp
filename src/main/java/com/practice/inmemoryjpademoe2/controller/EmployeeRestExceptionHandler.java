package com.practice.inmemoryjpademoe2.controller;

import com.practice.inmemoryjpademoe2.exceptions.EmployeeErrorResponse;
import com.practice.inmemoryjpademoe2.exceptions.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {
    /** Exception handling code goes here **/


    /** EmployeeNotFound error handling **/
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc){
        /** EmployeeErrorResponse **/
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        /** Return the error response **/
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /** Global Excetion error handling **/
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc){
        /** EmployeeErrorResponse **/
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        /** Return the error response **/
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
