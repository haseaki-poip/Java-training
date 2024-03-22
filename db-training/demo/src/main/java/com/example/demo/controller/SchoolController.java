package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.request.SchoolRequest;
import com.example.demo.controller.response.SchoolResponse;
import com.example.demo.service.SchoolService;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @PostMapping
    public void create(@RequestBody SchoolRequest request) {
        schoolService.create(request);
    }

    @PutMapping("{id}")
    public void update(@RequestBody SchoolRequest request, @PathVariable(name = "id") String id) {
        schoolService.update(id, request);
    }

    @GetMapping("{id}")
    public SchoolResponse findSchool(@PathVariable(name = "id") String id) {
        return schoolService.findSchool(id);
    }

    @GetMapping("/all")
    public List<SchoolResponse> findAllSchools() {
        return schoolService.findAllSchools();
    }
}
