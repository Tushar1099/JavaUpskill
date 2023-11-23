package com.assignment.controller;

import com.assignment.entity.Student;
import com.assignment.model.StudentData;
import com.assignment.model.StudentPost;
import com.assignment.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPostStudent() {
        
        StudentPost postStudent = new StudentPost();
        postStudent.setAge(25);
        postStudent.setSalary(50000.0);
        postStudent.setName("John Doe");

        Student savedStudent = Student.builder()
                .id(1)
                .age(postStudent.getAge())
                .salary(postStudent.getSalary())
                .name(postStudent.getName())
                .build();

        when(studentService.save(any(Student.class))).thenReturn(savedStudent);

        ResponseEntity<?> responseEntity = studentController.postStudent(postStudent);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(StudentData.builder()
                .id(savedStudent.getId())
                .age(savedStudent.getAge())
                .salary(savedStudent.getSalary())
                .name(savedStudent.getName())
                .build(), responseEntity.getBody());
    }

    @Test
    public void testGetStudentById() {
        
        int studentId = 1;
        Student student = Student.builder()
                .id(studentId)
                .age(25)
                .salary(50000.0)
                .name("John Doe")
                .build();

        when(studentService.getStudentById(studentId)).thenReturn(student);

        ResponseEntity<?> responseEntity = studentController.getStudetById(studentId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(StudentData.builder()
                .id(student.getId())
                .age(student.getAge())
                .salary(student.getSalary())
                .name(student.getName())
                .build(), responseEntity.getBody());
    }

   
}
