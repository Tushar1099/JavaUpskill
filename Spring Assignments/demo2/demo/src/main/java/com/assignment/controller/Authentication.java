package com.assignment.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.data.Data;
import com.assignment.models.User;

@RestController
@RequestMapping("/auth")
public class Authentication {
	
	@PutMapping("/user")
	public ResponseEntity<?> getUserData(@RequestBody User user){
		Data d = new Data();
		List<User> li = d.getData();
		for (User u : li) {
			if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
				return new ResponseEntity<>("Valid User.",HttpStatus.ACCEPTED);
			}
		}
		
		return new ResponseEntity<>("Invalid User.",HttpStatus.UNAUTHORIZED);
		
	}
}