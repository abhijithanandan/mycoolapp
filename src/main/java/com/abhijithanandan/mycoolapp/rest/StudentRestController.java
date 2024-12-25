package com.abhijithanandan.mycoolapp.rest;

import com.abhijithanandan.mycoolapp.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
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
            throw new RuntimeException("Student ID not found - " + studentId);
        }
    }
}
