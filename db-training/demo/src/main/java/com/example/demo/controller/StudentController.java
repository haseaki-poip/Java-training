package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.response.StudentResponse;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("{id}")
    public StudentResponse findStudent(@PathVariable(name = "id") String id) {
        return studentService.findStudent(id);
    }

    @GetMapping("/all")
    public List<StudentResponse> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/school/{name}")
    public List<StudentResponse> findStudentsBySchoolName(
            @PathVariable(name = "name") String name) {
        return studentService.findStudentsBySchoolName(name);
    }
}
