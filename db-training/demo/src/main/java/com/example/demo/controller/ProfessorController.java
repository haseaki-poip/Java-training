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
import com.example.demo.controller.request.ProfessorRequest;
import com.example.demo.controller.response.ProfessorResponse;
import com.example.demo.service.ProfessorService;

@RestController
@RequestMapping("/professors")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;

    @PostMapping
    public void create(@RequestBody ProfessorRequest request) {
        professorService.create(request);
    }

    @PutMapping("{id}")
    public void update(@RequestBody ProfessorRequest request,
            @PathVariable(name = "id") String id) {
        professorService.update(id, request);
    }

    @GetMapping("{id}")
    public ProfessorResponse findProfessor(@PathVariable("id") String id) {
        return professorService.findProfessor(id);
    }

    @GetMapping("/all")
    public List<ProfessorResponse> getAllProfessors() {
        return professorService.findAllProfessors();
    }
}
