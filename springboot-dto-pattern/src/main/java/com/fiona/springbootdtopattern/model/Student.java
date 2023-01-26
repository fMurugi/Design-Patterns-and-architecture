package com.fiona.springbootdtopattern.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="MathStudents")
public class Student {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

 //fetch earger means when both related entities will be loaded at the same time
    // sowhen i request student the location will aslo be loaded. opp is lazy loading
    @ManyToOne(fetch =FetchType.EAGER,optional = false)
    @JoinColumn(name="location_id")
    private Location location;

}
