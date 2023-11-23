package com.assignment.serviceImpl;

import com.assignment.entity.Student;
import com.assignment.model.StudentPost;
import com.assignment.repo.StudentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StudentServiceImplTest {

    @Mock
    private StudentRepo studentRepo;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveStudent() {
        
        Student studentToSave = Student.builder().id(1).name("John Doe").age(25).salary(50000.0).build();
        when(studentRepo.save(any(Student.class))).thenReturn(studentToSave);

        
        Student savedStudent = studentService.save(studentToSave);

 
        assertNotNull(savedStudent);
        assertEquals(1, savedStudent.getId());
        assertEquals("John Doe", savedStudent.getName());
        assertEquals(25, savedStudent.getAge());
        assertEquals(50000.0, savedStudent.getSalary(), 0.001);
    }

    @Test
    public void testGetStudentById() {
       
        int studentId = 1;
        Student student = Student.builder().id(studentId).name("Alice").age(30).salary(60000.0).build();
        when(studentRepo.findById(studentId)).thenReturn(Optional.of(student));

        Student foundStudent = studentService.getStudentById(studentId);


        assertNotNull(foundStudent);
        assertEquals(studentId, foundStudent.getId());
        assertEquals("Alice", foundStudent.getName());
        assertEquals(30, foundStudent.getAge());
        assertEquals(60000.0, foundStudent.getSalary(), 0.001);
    }

    @Test
    public void testUpdateStudent() {
        
        int studentId = 1;
        StudentPost postStudent = new StudentPost();
        postStudent.setAge(22);
        postStudent.setSalary(55000.0);
        postStudent.setName("Jane Doe");

        Student existingStudent = Student.builder().id(studentId).name("Alice").age(30).salary(60000.0).build();
        when(studentRepo.findById(studentId)).thenReturn(Optional.of(existingStudent));
        when(studentRepo.save(any(Student.class))).thenReturn(existingStudent);

        Student updatedStudent = studentService.updateStudent(postStudent, studentId);

        assertNotNull(updatedStudent);
        assertEquals(studentId, updatedStudent.getId());
        assertEquals("Jane Doe", updatedStudent.getName());
        assertEquals(22, updatedStudent.getAge());
        assertEquals(55000.0, updatedStudent.getSalary(), 0.001);
    }

    @Test
    public void testDeleteStudentById() {
        
        int studentId = 1;
        when(studentRepo.existsById(studentId)).thenReturn(true);

        
        String result = studentService.deleteStudentById(studentId);

   
        assertNotNull(result);
        assertEquals("Student deleted Succesfully", result);
        verify(studentRepo, times(1)).deleteById(studentId);
    }

    @Test
    public void testGetAllStudents() {
        
        Student student1 = Student.builder().id(1).name("John Doe").age(25).salary(50000.0).build();
        Student student2 = Student.builder().id(2).name("Jane Doe").age(22).salary(55000.0).build();
        List<Student> students = Arrays.asList(student1, student2);

        when(studentRepo.findAll()).thenReturn(students);

        List<Student> foundStudents = studentService.getAllStudent();

        assertNotNull(foundStudents);
        assertEquals(2, foundStudents.size());
        assertEquals("John Doe", foundStudents.get(0).getName());
        assertEquals("Jane Doe", foundStudents.get(1).getName());
    }

}
