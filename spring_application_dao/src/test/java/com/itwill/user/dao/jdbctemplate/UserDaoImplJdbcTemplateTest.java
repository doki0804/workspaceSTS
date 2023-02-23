package com.itwill.user.dao.jdbctemplate;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
@SpringBootTest
class UserDaoImplJdbcTemplateTest {
	@Autowired
	UserDao userDao;
	@Disabled
	@Test
	void testCreate() {
		User user = new User("jdbctemplate","1111","제이디비씨","jdbc@jdbc.com");
		try {
			int rowCount = userDao.create(user);
			assertEquals(rowCount, 1);
		} catch (Exception e) {
			assertInstanceOf(DuplicateKeyException.class, e);
		}
	}
	//@Disabled
	@Test
	void testUpdate() {
		User user = new User("test","2222","제이디비씨","jdbc@jdbc.com");
		try {
			int rowCount = userDao.update(user);
			assertEquals(rowCount, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Disabled
	@Test
	void testRemove() {
		String userId = "jdbctemplate";
		try {
			int rowCount = userDao.remove(userId);
			assertEquals(rowCount, 1);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Disabled
	@Test
	void testFindUser() {
		String userId = "test";
		try {
			User findUser = userDao.findUser(userId);
			assertNotNull(findUser);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Disabled
	@Test
	void testFindUserList() {
		try {
			List<User> userList = userDao.findUserList();
			assertNotNull(userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//@Disabled
	@Test
	void testExistedUser() {
		String userId = "test";
		try {
			boolean result = userDao.existedUser(userId);
			assertEquals(result, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
