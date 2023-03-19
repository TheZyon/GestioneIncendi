package com.SpringBoot_SpringSecurity.Exception;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> manageEntityNotFoundException(EntityNotFoundException e){
        return new ResponseEntity<>("Ao bello guarda che "+ e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
