package com.woongjin.springsi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woongjin.springsi.model.User;
import com.woongjin.springsi.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/greet")
	@ResponseBody
	public String hello() {
		return "Hello World...";
	}
	
//	@GetMapping("/users/3")
//	@ResponseBody
//	public User searchUserByUserid() {
//		
//		User user = userService.searchUserByUserid(3);
//		
//		return user;
//	}
	
}
