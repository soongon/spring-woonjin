package com.woongjin.springsi.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woongjin.springsi.model.User;

// Datasource 외부 데이터

@Repository
public class UserDao {
	
	private static String NAME_SPACE = "com.woongjin.springsi.dao.UserDao.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<User> selectAllUsers() {
		return sqlSession.selectList(NAME_SPACE + "selectAllUsers");
	}

	public User selectUserByKey(Integer userid) {
		return sqlSession.selectOne(NAME_SPACE + "selectUserByKey", userid);
	}
	
	public User insertUser(User user) {
		
		sqlSession.update(NAME_SPACE + "insertUser", user);
		return user;
	}
	
	public User updateUser(User user) {
		sqlSession.update(NAME_SPACE + "updateUser", user);
		return user;
	}
	
	public boolean deleteUser(Integer userid) {
		int updated = sqlSession.delete(NAME_SPACE + "deleteUser", userid);
		return updated > 0 ? true : false;
	}
	
}
