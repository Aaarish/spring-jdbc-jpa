package com.example.springjdbcjpa.controller;

import com.example.springjdbcjpa.entity.Student;
import com.example.springjdbcjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping
    public String addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return service.getStudent(id);
    }

    @GetMapping
    public List<Student> getStudents(){
        return service.getStudents();
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        return service.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student){
        return service.updateStudent(id, student);
    }
}
