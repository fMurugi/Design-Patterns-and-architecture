package com.fiona.springbootdtopattern;

import com.fiona.springbootdtopattern.model.Location;
import com.fiona.springbootdtopattern.model.Student;
import com.fiona.springbootdtopattern.repository.LocationRepository;
import com.fiona.springbootdtopattern.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.management.modelmbean.ModelMBeanAttributeInfo;

@SpringBootApplication
public class SpringbootDtoPatternApplication implements CommandLineRunner {

	//configure modelMapper as a bean
	//ie an object manged by the spring app and is used by any class when neede
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDtoPatternApplication.class, args);
	}
	//use the commandlineRunner interface to save data into the database when the
	//app start by implementing its runner method.
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void run(String... args) throws Exception {
		Location location = new Location();
		location.setPlace("Nairobi");
		location.setDescription("Near the Equator");
		location.setLongitude(30.9);
		location.setLatitude(40.00);
		locationRepository.save(location);

		Student student1= new Student();
		student1.setFirstName("Flora");
		student1.setLastName("Gakii");
		student1.setEmail("flora45@gmail.com");
		student1.setPassword("secret");
		student1.setLocation(location);
		studentRepository.save(student1);

		Student student2= new Student();
		student1.setFirstName("Fauna");
		student1.setLastName("Mumbi");
		student1.setEmail("flora45@gmail.com");
		student1.setPassword("123");
		student2.setLocation(location);
		studentRepository.save(student2);

	}
}
