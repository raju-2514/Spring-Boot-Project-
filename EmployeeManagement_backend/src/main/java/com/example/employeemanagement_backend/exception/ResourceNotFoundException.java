package com.example.employeemanagement_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends  RuntimeException{
    private static final long seriaVersionUID=1L;
    public  ResourceNotFoundException(String message)
    {
             super(message);
    }

}
