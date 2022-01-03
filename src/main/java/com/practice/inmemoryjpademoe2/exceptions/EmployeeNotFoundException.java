package com.practice.inmemoryjpademoe2.exceptions;

public class EmployeeNotFoundException extends RuntimeException{

    // main one

    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public EmployeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFoundException(Throwable cause) {
        super(cause);
    }

}
