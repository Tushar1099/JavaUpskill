package com.assignment.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.entity.Student;
import com.assignment.model.StudentPost;
import com.assignment.repo.StudentRepo;
import com.assignment.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentRepo repo;

	public Student save(Student student) {
		logger.info("Save method invoked." + student.toString());
		return repo.save(student);
	}

	public Student getStudentById(int id) {
		logger.info("getStudentById method invoked in service with ID." + id);
		return repo.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
	}

	public Student updateStudent(StudentPost postStudent, int id) {
		logger.info("updateStudent method invoked in service with ID." + id);
		Student student = getStudentById(id);
		if(postStudent.getAge()!=0) {
			student.setAge(postStudent.getAge());
		}
		if(postStudent.getName()!=null) {
			student.setName(postStudent.getName());
		}
		if(postStudent.getAge()!=0) {
			student.setSalary(postStudent.getSalary());
		}
		return repo.save(student);
	}

	@Override
	public String deleteStudentById(int id) {
		logger.info("deleteStudentByID method invoked in service with ID." + id);
		getStudentById(id);
		repo.deleteById(id);
		return "Student deleted Succesfully";
	}

	@Override
	public List<Student> getAllStudent() {
		logger.info("getAllStudent method invoked in service");
		return repo.findAll();
	}
}
