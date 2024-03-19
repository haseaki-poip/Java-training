package com.example.demo.controller.response;

import lombok.Data;

@Data
public class ProfessorResponse {
    private Integer id;
    private String name;
    private ProfessorInfoResponse professorInfo;
}
