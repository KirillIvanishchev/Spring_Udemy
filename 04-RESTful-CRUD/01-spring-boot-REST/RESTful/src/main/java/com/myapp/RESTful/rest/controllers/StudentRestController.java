package com.myapp.RESTful.rest.controllers;

import com.myapp.RESTful.entity.Student;
import com.myapp.RESTful.rest.errors.StudentErrorResponse;
import com.myapp.RESTful.rest.errors.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> listOfStudents;

    //@PostConstruct annotation was used before in this Course.
    //It is used to PRE initialize something.
    @PostConstruct
    public void StudentRestControllerInitialization() {
        listOfStudents = new ArrayList(
                Arrays.asList(
                        new Student("First", "First"),
                        new Student("Second", "Second"),
                        new Student("Third", "Third"),
                        new Student("Fourth", "Fourth")
                )
        );
    }

    // @GetMapping annotation is used to GET request. We simply TAKE and SHOW something on the screen.
    // So we define an Endpoint "/students" to return list of Students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return listOfStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        //THROW error when studentId is not valid

        if (studentId < 0 || studentId >= listOfStudents.size()) {
            throw new StudentNotFoundException("Student with id [" + studentId + "] not found");
        }
        return listOfStudents.get(studentId);
    }

    //Down part of the code was copied to @ControllerAdvice in StudentRestExceptionHandler for Best Practices.
    /*
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
*/
}
