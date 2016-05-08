package com.acceptedboy.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acceptedboy.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserService userService;

	@RequestMapping("/users/{userId}")
	public ResponseEntity<Void> getUser(@PathVariable String userId) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
