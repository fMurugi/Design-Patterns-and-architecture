package com.fiona.springbootdtopattern.repository;

import com.fiona.springbootdtopattern.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
