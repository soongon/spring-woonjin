package com.woongjin.springsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.woongjin.springsi.model.User;

// Datasource 외부 데이터

@Repository
public class UserDao {
	
	public List<User> selectAllUsers() {
		
		List<User> userList = new ArrayList<>();
		userList.add(new User(1, "kim", 30));
		userList.add(new User(2, "kwon", 40));
		userList.add(new User(3, "park", 50));
		userList.add(new User(4, "choi", 20));
		userList.add(new User(5, "lee", 10));
		
		return userList;
	}

	public User selectUserByKey(Integer userid) {
		// DB연동 코드가 실제로 포함됨 
		// DB연동 라이브러리는 MyBatis 사용
		if (userid == 4) {
			return new User(4, "류현진 ", 30);
		}
		else if (userid == 3) {
			return new User(3, "류현진 ", 20);
		}
		else {
			return new User(0, "aaaa", 30);
		}
	}
	
	public User insertUser(User user) {
		
		System.out.println("insert ok..");
		
		return user; //TODO
	}
	
	public User updateUser(User user) {
		return null; //TODO
	}
	
	public User deleteUser(Integer userid) {
		return null; //TODO
	}
	
}
