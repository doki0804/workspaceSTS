package com.itwill.user.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.itwill.user.dao.jdbc.User;
import com.itwill.user.dao.jdbc.UserDao;

@SpringBootApplication
@SpringBootTest
class UserDaoImplTest {
	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	private UserDao userDao;
	
	@Test
	void contextLoad() {
		System.out.println(applicationContext);
	}
	@Disabled
	@Test
	void testCreate() throws Exception {
		User user = new User("test","test","테스터","test@gmail.com");
		assertEquals(userDao.create(user), 1);
		
	}
	@Disabled
	@Test
	void testUpdate() throws Exception {
		User user = new User("test","test","테스트수정","update@gmail.com");
		assertEquals(userDao.update(user), 1);
	}
	@Disabled
	@Test
	void testRemove() throws Exception {
		assertEquals(userDao.remove("test"), 0);
	}
	@Disabled
	@Test
	void testFindUser() throws Exception {
		assertNotNull(userDao.findUser("test"));
	}
	@Disabled
	@Test
	void testFindUserList() throws Exception {
		assertNotNull(userDao.findUserList());
	}
	@Disabled
	@Test
	void testExistedUser() throws Exception {
		assertEquals(userDao.existedUser("test"), true);
	}

}
