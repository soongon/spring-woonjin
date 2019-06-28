package com.woongjin.springsi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.woongjin.springsi.annotation.TokenRequired;
import com.woongjin.springsi.model.User;
import com.woongjin.springsi.service.UserService;

@RestController
public class UserManagementController {
	
	private static Logger log = 
			LoggerFactory.getLogger(UserManagementController.class);
	
	@Autowired
	private UserService userService;
	
	
	@TokenRequired
	@GetMapping("/users")
	public Map<String, Object> searchUsers() {
		List<User> listOfUser = userService.searchAllUsers();
		
		Map<String, Object> result = new HashMap<>();
		result.put("status", true);
		result.put("datetime", new Date());
		result.put("data", listOfUser);
		return result;
	}
	
	// /leagues/{leagueid}/teams/{teamid}/players/{playerid}
	
	//@GetMapping("/users/{userid}/hobbys/{hobbyid}")
	@GetMapping("/users/{userid}")
	public User searchUserByUserid(@PathVariable Integer userid
								  /* @PathVariable String hobbyid */) {
		
		
		
		log.debug("" + userid);
		return userService.searchUserByUserid(userid);
	}
	
	@PostMapping("/users")
	public User registUser(@RequestBody User user) {
		
		
		System.out.println(user);
		return userService.registUser(user);
	}
	
	@PutMapping("/users")
	public User modifyUser(@RequestBody User user) {
		return userService.modifyUserInfo(user);
	}
	
	@DeleteMapping("/users/{userid}")
	public Map<String, Object> removeUser(@PathVariable Integer userid) {
		boolean isDeleted = userService.removeUser(userid);
		Map<String, Object> map = new HashMap<>();
		map.put("deleted", isDeleted);
		map.put("deletedUserid", userid);
		return map;
	}
	
	/*
	 
	/users [GET] : 사용자 전체보기 List<User> searchUsers
	
	/users/3 [GET] : 사용자 상세보기 User searchUserByUserid(userid)
	
	/users [POST] : 사용자 등록 User registUser(User)
	
	/users [PUT] : 사용자 수정 User modifyUser(User)
	
	/users/3 [DELETE] : 사용자 삭제 Map removeUser(userid)


	 */

}
