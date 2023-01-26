package com.fiona.springbootdtopattern.Controller;

import com.fiona.springbootdtopattern.dto.StudentLocationDTO;
import com.fiona.springbootdtopattern.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("students/location")
    public List<StudentLocationDTO> getAllStudentsLocation(){
        return studentService.getAllStudentsLocation();
    }


}
