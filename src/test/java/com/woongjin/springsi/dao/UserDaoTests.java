package com.woongjin.springsi.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woongjin.springsi.model.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTests {
	
	@Autowired
	private UserDao userDao;

	@Ignore
	@Test
	public void testInsertUser() {
		User user = new User(201, "류현진 ", 30);
		User returned = userDao.insertUser(user);
		
		Assert.assertTrue(returned.getUserid() == 200);
	}
	
	@Test
	public void testSelectAllUsers() {
		List<User> listOfUser = userDao.selectAllUsers();
		Assert.assertNotNull(listOfUser);
	}
	
	@Test
	public void testUpdateUser() {
		// 1번 유저의이름과 나이를 변경
		User user = new User(1, "추신수 ", 35);
		User result = userDao.updateUser(user);
		Assert.assertNotNull(result);
	}
}


