package com.assignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entity.Student;
import com.assignment.model.StudentData; 
import com.assignment.model.StudentPost;
import com.assignment.service.StudentService;

@RestController
@RequestMapping("/student") 
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> postStudent(@RequestBody StudentPost postStudent) {
		logger.info("postStudent method invoked");
		Student student = Student.builder()
							.age(postStudent.getAge())
							.salary(postStudent.getSalary())
							.name(postStudent.getName())
							.build();
		
		return new ResponseEntity<>(convertToDto(service.save(student)),HttpStatus.OK);
		
	}
	
	@GetMapping("/get/{id}")
	public  ResponseEntity<?>  getStudetById(@PathVariable int id) {
		logger.info("getStudentById method invoked");
		return new ResponseEntity<>(convertToDto(service.getStudentById(id)),HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public  ResponseEntity<?>  updateStudent(@RequestBody StudentPost postStudent , @PathVariable int id) {
		logger.info("updateStudentById method invoked");
		return new ResponseEntity<>(convertToDto(service.updateStudent(postStudent,id)),HttpStatus.OK);
	}

	@DeleteMapping("/delete//{id}")
	public  ResponseEntity<?>  deleteStudetById(@PathVariable int id) {
		logger.info("deleteStudentById method invoked");
		return new ResponseEntity<>(service.deleteStudentById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public  ResponseEntity<?> getAllStudent() {
		logger.info("getAllStudents method invoked");
		return new ResponseEntity<>(service.getAllStudent(),HttpStatus.OK);
	}
 
	public StudentData convertToDto(Student save) {
		return StudentData.builder()
					.id(save.getId())
					.name(save.getName())
					.salary(save.getSalary())
					.age(save.getAge())
					.build();
	}
}
