package com.example.springjdbcjpa.service;

import com.example.springjdbcjpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StudentServiceJdbcImpl implements StudentService{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String addStudent(Student student) {
        String query = "insert into students values(?, ?, ?)";

        int rows = jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return "Student saved successfully";
    }

    @Override
    public Student getStudent(int id) {
        String query = "select * from students where id = ?";

        Map<String, Object> map = jdbcTemplate.queryForMap(query, id);
        Student student = new Student();

        student.setId((int) map.get("id"));
        student.setName((String) map.get("name"));
        student.setCity((String) map.get("city"));

        return student;
    }

    @Override
    public List<Student> getStudents() {
        String query = "select * from students";

        List<Student> studentList = jdbcTemplate.queryForList(query).stream()
                .map(map -> {
                    Student student = new Student();

                    student.setId((int) map.get("id"));
                    student.setName((String) map.get("name"));
                    student.setCity((String) map.get("city"));

                    return student;
                })
                .collect(Collectors.toList());

        return studentList;
    }

    @Override
    public String deleteStudent(int id) {
        String query = "delete from students where id = ?";

        int rows = jdbcTemplate.update(query, id);
        return "Student deleted successfully";
    }

    @Override
    public String updateStudent(int id, Student student) {
        String query = "update students set id = ?, name = ?, city = ? where id = ?";

        jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity(), id);
        return "Student updated successfully";
    }
}