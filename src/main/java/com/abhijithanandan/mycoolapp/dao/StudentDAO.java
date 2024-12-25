package com.abhijithanandan.mycoolapp.dao;

import com.abhijithanandan.mycoolapp.entity.Student;

public interface StudentDAO {
    void save (Student student);

    // Add a method to get a student by id
    Student findById(int id);
}
