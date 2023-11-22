package com.assignment.service;

import java.util.List;

import com.assignment.entity.Student;
import com.assignment.model.StudentPost;

public interface StudentService {
	
	public Student save(Student student);

	public Student getStudentById(int id);
	
	public Student updateStudent(StudentPost postStudent, int id);

	public String deleteStudentById(int id);

	public List<Student> getAllStudent();
}
