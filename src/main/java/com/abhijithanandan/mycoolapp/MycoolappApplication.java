package com.abhijithanandan.mycoolapp;

import com.abhijithanandan.mycoolapp.dao.StudentDAO;
import com.abhijithanandan.mycoolapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MycoolappApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycoolappApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDao) {
        return runner  -> {
            createStudent(studentDao);
        };
    }

    private void createStudent(StudentDAO studentDao) {

        // create the student object
        System.out.println("Creating a new student object");
        Student student = new Student("John", "Doe", "paul@luv2code.com");

        // save the student
        System.out.println("Saving the student");
        studentDao.save(student);

        // display the student
        System.out.println(student);


    }

}
