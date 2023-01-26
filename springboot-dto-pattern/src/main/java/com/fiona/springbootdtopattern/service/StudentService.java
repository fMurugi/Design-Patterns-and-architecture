package com.fiona.springbootdtopattern.service;

import com.fiona.springbootdtopattern.dto.StudentLocationDTO;
import com.fiona.springbootdtopattern.model.Student;
import com.fiona.springbootdtopattern.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;

    // the map() method applies the convertEntityToDto method to each element in the stream,
    // which is an instance of the Student class, and returns a new stream with elements of StudentLocationDTO class.
    public List<StudentLocationDTO> getAllStudentsLocation(){
        return studentRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList()); //converts the dto to a list
    }

//    private StudentLocationDTO convertEntityToDto(Student student){
//        StudentLocationDTO studentLocationDTO = new StudentLocationDTO();
//        studentLocationDTO.setStudentId(student.getId());
//        studentLocationDTO.setEmail(student.getEmail());
//        studentLocationDTO.setPlace(student.getLocation().getPlace());
//        return studentLocationDTO;
//    }
    private StudentLocationDTO convertEntityToDto(Student student){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        StudentLocationDTO studentLocationDTO = new StudentLocationDTO();
        //replace all the code with a model mapper
        studentLocationDTO = modelMapper.map(student, StudentLocationDTO.class);
        return studentLocationDTO;
    }

    //convert dto  to a jpa entity
    private Student convertDtoToStudent(StudentLocationDTO   studentLocationDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Student student = new Student();
        //replace all the code with a model mapper
        student = modelMapper.map(studentLocationDTO, Student.class);
        return student;
    }

}
