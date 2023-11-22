package com.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.entity.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
