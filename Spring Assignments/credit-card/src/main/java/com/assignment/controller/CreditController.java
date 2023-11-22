package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.creditservice.CreditService;

@RestController
@RequestMapping("/web")
public class CreditController {

	@Autowired
	private CreditService creditservice;
	
	@GetMapping("/creditno/{no}")
	public ResponseEntity<?> getCreditInfo(@PathVariable String no ){
		return ResponseEntity.ok(creditservice.ValidateCreditCard(no));
	}
	
}
