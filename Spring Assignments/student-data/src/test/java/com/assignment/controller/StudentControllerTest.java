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
 
import java.util.Arrays;
import java.util.List;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
 
class StudentControllerTest {
 
    @Mock
    private StudentService studentServiceMock;
 
    @InjectMocks
    private StudentController studentController;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    void testPostStudent() {
     
        StudentPost studentPost = new StudentPost();
        studentPost.setName("John");
        studentPost.setAge(25);
        studentPost.setSalary(50000.0);
 
        Student savedStudent = new Student();
        savedStudent.setId(1);
        savedStudent.setName("John");
        savedStudent.setAge(25);
        savedStudent.setSalary(50000.0);
 
        when(studentServiceMock.save(any())).thenReturn(savedStudent);
 
        
        ResponseEntity<?> responseEntity = studentController.postStudent(studentPost);
 
        
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
//        assertTrue(responseEntity.getBody() instanceof StudentData);
 
        StudentData studentData = (StudentData) responseEntity.getBody();
        assertEquals(1L, studentData.getId());
        assertEquals("John", studentData.getName());
        assertEquals(25, studentData.getAge());
        assertEquals(50000.0, studentData.getSalary());
    }
 
    @Test
    void testGetStudentById() {
        
        int studentId = 1;
        Student student = new Student();
        student.setId(1);
        student.setName("John");
        student.setAge(25);
        student.setSalary(50000.0);
 
        when(studentServiceMock.getStudentById(studentId)).thenReturn(student);
 
        
        ResponseEntity<?> responseEntity = studentController.getStudetById(studentId);
 
    
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
//        assertTrue(responseEntity.getBody() instanceof StudentData);
 
        StudentData studentData = (StudentData) responseEntity.getBody();
        assertEquals(1L, studentData.getId());
        assertEquals("John", studentData.getName());
        assertEquals(25, studentData.getAge());
        assertEquals(50000.0, studentData.getSalary());
    }
 
}
