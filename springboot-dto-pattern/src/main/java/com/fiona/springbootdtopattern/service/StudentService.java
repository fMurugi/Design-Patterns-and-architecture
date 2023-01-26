package com.fiona.springbootdtopattern.service;

import com.fiona.springbootdtopattern.dto.StudentLocationDTO;
import com.fiona.springbootdtopattern.model.Student;
import com.fiona.springbootdtopattern.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // the map() method applies the convertEntityToDto method to each element in the stream,
    // which is an instance of the Student class, and returns a new stream with elements of StudentLocationDTO class.
    public List<StudentLocationDTO> getAllStudentsLocation(){
        return studentRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList()); //converts the dto to a list
    }

    private StudentLocationDTO convertEntityToDto(Student student){
        StudentLocationDTO studentLocationDTO = new StudentLocationDTO();
        studentLocationDTO.setStudentId(student.getId());
        studentLocationDTO.setEmail(student.getEmail());
        studentLocationDTO.setPlace(student.getLocation().getPlace());
        return studentLocationDTO;
    }

}
