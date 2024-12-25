package com.abhijithanandan.mycoolapp.dao;

import com.abhijithanandan.mycoolapp.entity.Student;
import java.util.List;

public interface StudentDAO {
    void save (Student student);

    // Add a method to get a student by id
    Student findById(int id);

    List<Student> findAll();

    List<Student> findByFirstName(String firstName);

    void update(Student student);

    void deleteById(int id);
}
