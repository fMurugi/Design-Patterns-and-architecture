package com.fiona.springbootdtopattern.dto;

import lombok.Data;

@Data  //for getter and setters
public class StudentLocationDTO {
    private Long studentId;
    private String email;
    private String place;
}
