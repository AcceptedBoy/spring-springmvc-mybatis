package com.acceptedboy.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acceptedboy.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	public UserService userService;

	@RequestMapping("/getUser")
	public Object getUser(@RequestParam(required=false)String id) {
		
		System.out.println(userService.selectByPrimaryKey(id));
		return "index";
	}
}
