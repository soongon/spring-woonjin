package com.woongjin.springsi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.woongjin.springsi.service.SecurityService;

@RestController
public class SecurityController {
	
	@Autowired
	private SecurityService securityService;
	
	// .. /auth/token
	@GetMapping("/auth/token")
	public Map<String, Object> generateTokenWithUserid(
									@RequestParam String userid) {
		
		String token = securityService.generateToken(userid);
		
		Map<String, Object> result = new HashMap<>();
		result.put("token", token);
		return result;
	}

}
