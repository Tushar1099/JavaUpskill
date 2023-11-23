package com.assignment.model;

import com.assignment.model.StudentPost;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentPostTest {

    @Test
    public void testStudentPostConstruction() {
        
        int age = 25;
        String name = "John Doe";
        double salary = 50000.0;

        StudentPost studentPost = StudentPost.builder()
                .age(age)
                .name(name)
                .salary(salary)
                .build();

        assertNotNull(studentPost);
        assertEquals(age, studentPost.getAge());
        assertEquals(name, studentPost.getName());
        assertEquals(salary, studentPost.getSalary(), 0.001); 
    }

}
