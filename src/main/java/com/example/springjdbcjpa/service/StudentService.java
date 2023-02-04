package com.example.springjdbcjpa.service;

import com.example.springjdbcjpa.entity.Student;

import java.util.List;

public interface StudentService {
    String addStudent(Student student);

    Student getStudent(int id);

    List<Student> getStudents();

    String deleteStudent(int id);

    String updateStudent(int id, Student student);
}
