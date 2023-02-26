package com.itwill.user.dao.mybatis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class UserDaoImplMyBatisTest {
	
	@Autowired
	UserDao userDao;
	
	@Disabled
	@Transactional
	@Test
	void testCreate() throws Exception {
		assertEquals(userDao.create(new User("hohoho","1111","호호","hoho@hoho.com")), 1);

	}
	
	@Transactional
	@Disabled
	@Test
	void testUpdate() throws Exception {
		assertEquals(userDao.update(new User("test","1111","호호","hoho@hoho.com")), 1);
	}

	@Transactional
	//@Disabled
	@Test
	void testRemove() throws Exception {
		assertEquals(userDao.remove("test"), 1);
	}

	@Disabled
	@Test
	void testFindUser() throws Exception {
		assertNotNull(userDao.findUser("test"));
		System.out.println(userDao.findUser("test"));
		
	}

	//@Disabled
	@Test
	void testFindUserList() throws Exception {
		assertNotNull(userDao.findUserList());
		System.out.println(userDao.findUserList());
	}

	@Disabled
	@Test
	void testExistedUser() {
		fail("Not yet implemented");
	}

}
