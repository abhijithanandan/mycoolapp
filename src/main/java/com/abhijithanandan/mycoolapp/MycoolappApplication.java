package com.abhijithanandan.mycoolapp;

import com.abhijithanandan.mycoolapp.dao.StudentDAO;
import com.abhijithanandan.mycoolapp.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
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
//        return runner  -> createStudent(studentDao);
        return runner -> createMultipleStudents(studentDao);
//        return runner -> readStudent(studentDao);
//        return runner -> queryStudents(studentDao);
//        return runner -> queryStudentsbyFirstName(studentDao);
//        return runner -> updateStudent(studentDao);
//        return runner -> deleteStudent(studentDao);
//        return runner -> deleteAllStudents(studentDao);
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

    private void createMultipleStudents(StudentDAO studentDao) {
    // create multiple student objects
    System.out.println("Creating multiple student objects");
    Student student1 = new Student("John", "Doe", "john@luv2code.com");
    Student student2 = new Student("Mary", "Public", "mary@luv2code.com");
    Student student3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

    // save the students
    System.out.println("Saving the students");
    studentDao.save(student1);
    studentDao.save(student2);
    studentDao.save(student3);

    // display the students
    System.out.println(student1);
    System.out.println(student2);
    System.out.println(student3);
}

    private void readStudent(StudentDAO studentDao) {
        // get the student by id
        System.out.println("Getting student by id");
        Student student = studentDao.findById(1);
        System.out.println(student);
    }

    private void queryStudents(StudentDAO studentDao) {
        // get all students
        System.out.println("Getting all students");
        studentDao.findAll().forEach(System.out::println);
    }

    private void queryStudentsbyFirstName(StudentDAO studentDao) {
        // get all students
        System.out.println("Getting all students by first name");
        studentDao.findByFirstName("John").forEach(System.out::println);
    }

    private void updateStudent(StudentDAO studentDao) {
        // get the student by id
        System.out.println("Getting student by id");
        Student student = studentDao.findById(1);
        System.out.println(student);

        // update the student
        System.out.println("Updating the student");
        student.setFirstName("Scooby");
        studentDao.update(student);

        // get the student by id
        System.out.println("Getting student by id");
        student = studentDao.findById(1);
        System.out.println(student);
    }

    private void deleteStudent(StudentDAO studentDao) {
        // get the student by id
        System.out.println("Getting student by id");
        Student student = studentDao.findById(1);
        System.out.println(student);

        // delete the student
        System.out.println("Deleting the student");
        studentDao.deleteById(1);

        // get all students
        System.out.println("Getting all students");
        studentDao.findAll().forEach(System.out::println);
    }

    private void deleteAllStudents(StudentDAO studentDao) {
        // get all students
        System.out.println("Getting all students");
        studentDao.findAll().forEach(System.out::println);

        // delete all students
        System.out.println("Deleting all students");
        int num = studentDao.deleteAll();

        // get all students
        System.out.println("Number of rows deleted: " + num);
    }
}
