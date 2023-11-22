package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entity.Student;
import com.assignment.model.StudentData;
import com.assignment.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;

	public Student save(Student student) {
		
		return repo.save(student);
	}

	public Student findById(int id) {
		return repo.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
	}
}
