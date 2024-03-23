package com.example.demo.controller.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StudentResponse {
    private int id;
    private String name;
    private SimpleSchoolResponse school;
}


@Data
class SimpleSchoolResponse {
    private int id;
    private String name;
}
