package com.assignment.model;

import com.assignment.model.StudentData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentDataTest {

    @Test
    public void testStudentDataConstruction() {
        
        int id = 1;
        String name = "John Doe";
        int age = 25;
        double salary = 50000.0;

        StudentData studentData = StudentData.builder()
                .id(id)
                .name(name)
                .age(age)
                .salary(salary)
                .build();

        assertNotNull(studentData);
        assertEquals(id, studentData.getId());
        assertEquals(name, studentData.getName());
        assertEquals(age, studentData.getAge());
        assertEquals(salary, studentData.getSalary(), 0.001); 
    }

}
