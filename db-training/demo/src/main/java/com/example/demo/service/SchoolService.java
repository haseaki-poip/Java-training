package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import com.example.demo.controller.request.SchoolRequest;
import com.example.demo.controller.request.StudentRequest;
import com.example.demo.controller.response.SchoolResponse;
import com.example.demo.entity.SchoolEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.SchoolRepository;
import com.example.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepo;
    private final StudentRepository studentRepo;
    private final ModelMapper modelMapper;

    public void create(SchoolRequest request) {
        SchoolEntity requestEntity = modelMapper.map(request, SchoolEntity.class);
        // save School
        SchoolEntity savedSchoolEntity = schoolRepo.save(requestEntity);
        // save Student
        Set<StudentEntity> studentEntities = requestEntity.getStudents();
        studentEntities.forEach(student -> student.setSchool(savedSchoolEntity));
        studentRepo.saveAll(studentEntities);
    }

    @Transactional
    public void update(String id, SchoolRequest request) {
        SchoolEntity schoolEntity = schoolRepo.findSchool(Integer.valueOf(id))
                .orElseThrow(() -> new RuntimeException("NOT FOUND SCHOOL"));
        // update school
        schoolEntity.setName(request.getName());
        schoolRepo.save(schoolEntity);
        // update students
        List<StudentEntity> studentEntities = new ArrayList<>();
        for (StudentRequest studentRequest : request.getStudents()) {
            StudentEntity studentEntity = studentRepo.findById(studentRequest.getId())
                    .orElseThrow(() -> new RuntimeException("NOT FOUND STUDENT"));
            studentEntity.setName(studentRequest.getName());
            studentEntities.add(studentEntity);
        }
        studentRepo.saveAll(studentEntities);
    }

    public SchoolResponse findSchool(String id) {
        SchoolEntity schoolEntity = schoolRepo.findSchool(Integer.valueOf(id))
                .orElseThrow(() -> new RuntimeException("NOT FOUND SCHOOL"));

        return modelMapper.map(schoolEntity, SchoolResponse.class);
    }

    public List<SchoolResponse> findAllSchools() {
        List<SchoolEntity> schoolEntities = schoolRepo.findAllSchools();

        return modelMapper.map(schoolEntities, new TypeToken<List<SchoolResponse>>() {}.getType());
    }
}
