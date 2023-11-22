package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entity.Student;
import com.assignment.model.StudentData;
import com.assignment.model.StudentPost;
import com.assignment.service.StudentService;



@RestController
@RequestMapping("/web")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping
	public StudentData postStudent(@RequestBody StudentPost postStudent) {
		
		Student student = Student.builder()
							.age(postStudent.getAge())
							.salary(postStudent.getSalary())
							.name(postStudent.getName())
							.build();
		
		return convertToDto(service.save(student));
		
	}
	
	@GetMapping("/{id}")
	public StudentData getStudet(@PathVariable int id) {
		return convertToDto(service.findById(id));
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
