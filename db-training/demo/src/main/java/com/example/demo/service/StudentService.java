package com.example.demo.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import com.example.demo.controller.response.SchoolResponse;
import com.example.demo.controller.response.StudentResponse;
import com.example.demo.entity.SchoolEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.SchoolRepository;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final SchoolRepository schoolRepo;
    private final StudentRepository studentRepo;
    private final ModelMapper modelMapper;

    public StudentResponse findStudent(String id) {
        StudentEntity studentEntity = studentRepo.findStudent(Integer.valueOf(id))
                .orElseThrow(() -> new RuntimeException("NOT FOUND SCHOOL"));

        return modelMapper.map(studentEntity, StudentResponse.class);
    }

    public List<StudentResponse> findAllStudents() {
        List<StudentEntity> studentEntities = studentRepo.findAllStudents();

        return modelMapper.map(studentEntities,
                new TypeToken<List<StudentResponse>>() {}.getType());
    }

    public List<StudentResponse> findStudentsBySchoolName(String name) {
        List<StudentEntity> studentEntities = studentRepo.findStudentsBySchoolName(name);
        return modelMapper.map(studentEntities,
                new TypeToken<List<StudentResponse>>() {}.getType());
    }
}
