package com.assignment.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.data.Data;
import com.assignment.models.Info;
import com.assignment.models.User;

@RestController
@RequestMapping("/web")
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
	
	@GetMapping("/zip/{id}")
	public ResponseEntity<?> getZipcodeData(@PathVariable("id") int pincode){
		Data d1 = new Data();
		List<Info> li = d1.getZipData();
		for (Info i : li) {
			if(i.getPincode() == pincode) {
				return ResponseEntity.status(HttpStatus.OK).body(i);
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
		
	}
}