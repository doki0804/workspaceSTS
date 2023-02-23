package com.itwill.guest.dao.jdbctemplate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class GuestDaoImplJdbcTemplateTest {
	@Autowired
	GuestDao guestDao;
	@Disabled
	@Test
	void testSelectAll() throws Exception {
		assertNotNull(guestDao.selectAll());
		assertNotEquals(guestDao.selectAll().size(), 0);
		System.out.println(guestDao.selectAll());
	}
	@Disabled
	@Test
	void testSelectByNo() throws Throwable {
		assertNotNull(guestDao.selectByNo(196));
	}
	@Disabled
	@Test
	void testInsertGuest() throws Exception {
		Guest guest = new Guest(0,"test",null,"test@test.com","test.com","테스트","테스트");
		assertEquals(guestDao.insertGuest(guest), 1);
	}
	@Disabled
	@Test
	void testUpdateGuest() throws Exception {
		Guest guest = new Guest(203,"test",null,"test@test.com","test.com","테스트","테스트");
		assertEquals(guestDao.updateGuest(guest), 1);
	}
	@Disabled
	@Test
	void testDeleteGuest() throws Exception {
		assertEquals(guestDao.deleteGuest(196), 1);
	}

}
