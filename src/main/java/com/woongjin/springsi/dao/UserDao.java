package com.woongjin.springsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woongjin.springsi.model.User;

// Datasource 외부 데이터

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
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
		return sqlSession.selectOne(
				"com.woongjin.springsi.dao.UserDao.selectUserByKey", userid);
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
