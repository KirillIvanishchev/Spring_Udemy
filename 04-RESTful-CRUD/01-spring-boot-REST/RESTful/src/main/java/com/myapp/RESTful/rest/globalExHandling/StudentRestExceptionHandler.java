package com.myapp.RESTful.rest.globalExHandling;

import com.myapp.RESTful.rest.errors.StudentErrorResponse;
import com.myapp.RESTful.rest.errors.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


//ControllerAdvice annotation is used to handle exceptions GLOBALLY.
//Basically we can handle exceptions in @RestController, BUT we can also inject (like use an addition) exceptions
// in foreign part of our code (because we can have multiple @RestController classes).
// this is Best Practice and allows us not to duplicate code.
@ControllerAdvice
public class StudentRestExceptionHandler {

    // @ExceptionHandler annotation is used to handle exceptions. We can handle Custom Exceptions (StudentNotFoundException),
    // and Generic Exceptions (Exception).
    //HANDLING ERRORS shows errors in the http JSON format logs. (Basically on the http site)
    //HANDLE error, when studentId is not valid.
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException ex) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAnyOtherExceptions(Exception ex) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }
}
