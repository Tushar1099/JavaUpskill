package com.course.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.bean.Student;

@RestController
@RequestMapping("/student-data")
public class StudentController {

	@GetMapping("/get-student")
	public ResponseEntity<Student> getStudent() {
		Student st = new Student(1, "tushar", "dhembare");
//		return new ResponseEntity<>(st, HttpStatus.OK);
//		return ResponseEntity.ok(st);
		return ResponseEntity.ok().header("custom-header", "tushar").body(st);
	}

	@GetMapping("/get-students")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> stlist = new ArrayList<>();
		stlist.add(new Student(1, "tushar", "dhembare"));
		stlist.add(new Student(2, "elon", "musk"));
		stlist.add(new Student(3, "adam", "champ"));
		stlist.add(new Student(4, "eva", "qwerty"));
		return ResponseEntity.ok(stlist);
	}

	@GetMapping("/get-student/{id}/{first-name}/{last-name}")
	public ResponseEntity<Student> getStudentPathVaribale(@PathVariable("id") int studentID,
														  @PathVariable("first-name") String firstName, 
														  @PathVariable("last-name") String lastName) {
		Student st = new Student(studentID, firstName, lastName);
		return ResponseEntity.ok(st);
	}

	// http://localhost:8080/get-student/query?id=1&firstName=tushar&&lastName=abc
	@GetMapping("/get-student/query")
	public ResponseEntity<Student> StudentRequestParam(@RequestParam int id, 
													   @RequestParam String firstName,
													   @RequestParam String lastName) {
		Student st = new Student(id, firstName, lastName);
		return ResponseEntity.ok(st);
	}
	
	@PostMapping("/create-student")
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}
	
	@PutMapping("update-student/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable int id) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return ResponseEntity.ok(student);
	}
	
	@DeleteMapping("/delete-student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		System.out.println(id);
		return ResponseEntity.ok("Student deleted successfully.");
	}
}
