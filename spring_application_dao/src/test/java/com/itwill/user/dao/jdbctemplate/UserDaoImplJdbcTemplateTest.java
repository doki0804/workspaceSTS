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
	void testUpdate() throws Exception {
		User user = new User("test","2222","제이디비씨","jdbc@jdbc.com");
		assertEquals(userDao.update(user), 1);
	}
	@Disabled
	@Test
	void testRemove() throws Exception {
		String userId = "jdbctemplate";
		assertEquals(userDao.remove(userId), 1);
	}
	@Disabled
	@Test
	void testFindUser() throws Exception {
		String userId = "test";
		assertNotNull(userDao.findUser(userId));
	}
	@Disabled
	@Test
	void testFindUserList() throws Exception {
		assertNotNull(userDao.findUserList());
	}
	//@Disabled
	@Test
	void testExistedUser() throws Exception {
		String userId = "test";
		assertTrue(userDao.existedUser(userId));
	}

}
