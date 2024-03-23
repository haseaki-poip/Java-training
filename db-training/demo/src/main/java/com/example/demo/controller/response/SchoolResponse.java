package com.example.demo.controller.response;

import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SchoolResponse {
    private int id;
    private String name;
    private Set<SimpleStudentResponse> students;
}


@Data
class SimpleStudentResponse {
    private int id;
    private String name;
}
