package com.assignment.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StudentTest {

    @Test
    public void testStudentCreation() {
        
        Student student = Student.builder()
                .id(1)
                .age(20)
                .name("John Doe")
                .salary(50000.0)
                .build();

        assertNotNull(student);
        assertEquals(1, student.getId());
        assertEquals(20, student.getAge());
        assertEquals("John Doe", student.getName());
        assertEquals(50000.0, student.getSalary(), 0.001); // Using delta for double comparison
    }

    @Test
    public void testStudentEquality() {
        
        Student student1 = Student.builder().id(1).age(25).name("Alice").salary(60000.0).build();
        Student student2 = Student.builder().id(1).age(25).name("Alice").salary(60000.0).build();
        Student student3 = Student.builder().id(2).age(30).name("Bob").salary(70000.0).build();

        assertEquals(student1, student2);
        assertNotEquals(student1, student3);
    }

    @Test
    public void testStudentToString() {
        
        Student student = Student.builder().id(1).age(22).name("Jane").salary(55000.0).build();

        String toStringResult = student.toString();

        assertTrue(toStringResult.contains("id=1"));
        assertTrue(toStringResult.contains("age=22"));
        assertTrue(toStringResult.contains("name=Jane"));
        assertTrue(toStringResult.contains("salary=55000.0"));
    }

}
