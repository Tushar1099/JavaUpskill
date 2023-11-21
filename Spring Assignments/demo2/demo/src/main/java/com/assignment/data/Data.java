package com.assignment.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.assignment.models.User;

@Component
public class Data {
	
	public List<User> getData() {
		List<User> list = new ArrayList<>();
		list.add( new User("user","pass"));
		return list;
	}
	
}
