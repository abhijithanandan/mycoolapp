package com.abhijithanandan.mycoolapp.rest;

import com.abhijithanandan.mycoolapp.entity.Student;
import com.abhijithanandan.mycoolapp.exceptions.StudentErrorResponse;
import com.abhijithanandan.mycoolapp.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        System.out.println("Loading data");

        students = new ArrayList<>();

        students.add(new Student("John", "Doe", "jondoe@gmail.com"));
        students.add(new Student("Mary", "Public", "marypublic@gmail.com"));
        students.add(new Student("Bon", "Applebum", "bon@gmail.com"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= 0 && studentId < students.size()) {
            return students.get(studentId);
        } else {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
    }

    // Add an Exception Handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
