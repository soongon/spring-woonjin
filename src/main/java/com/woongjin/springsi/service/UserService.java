package com.woongjin.springsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woongjin.springsi.dao.UserDao;
import com.woongjin.springsi.model.User;

// 시스템 기능(요구사항)을 표현(작성)
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	// 사용자 등록 
	public User registUser(User user) {
		return userDao.insertUser(user);
	}
	// 전체 사용자 조회 
	public List<User> searchAllUsers() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userDao.selectAllUsers();
	}
	// 사용자 아이디로 조회
	public User searchUserByUserid(Integer userid) {
		return userDao.selectUserByKey(userid);
	}
	
	// 사용자 정보 수정 
	public User modifyUserInfo(User user) {
		return userDao.updateUser(user);
	}
	// 사용자 삭제 
	public boolean removeUser(Integer userid) {
		return userDao.deleteUser(userid);
	}
}

