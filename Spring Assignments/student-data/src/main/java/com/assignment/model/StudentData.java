package com.assignment.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
 
public class StudentData {
	
	private int id;
	private String name;
	private int age;
	private double salary;
	
	public StudentData() {
		super();
	}

	public StudentData(int id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
}
