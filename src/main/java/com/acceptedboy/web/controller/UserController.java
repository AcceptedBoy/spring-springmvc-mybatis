package com.acceptedboy.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acceptedboy.domain.po.User;
import com.acceptedboy.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;

	@RequestMapping("/getUser")
	public ResponseEntity<Void> getUser(@RequestParam(required=true)String id) {
		
		User user = new User();
		user.setId("12");
		user.setUsername("32");
		user.setPassword("111");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
