package com.itwill.guest.dao.mybatis;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@SpringBootTest
class GuestDaoImplMyBatisTest {
	
	@Autowired
	GuestDao guestDao;
	
	@Test
	void testSelectAll() throws Throwable {
		assertNotNull(guestDao.selectAll());
		System.out.println(guestDao.selectAll());
	}
	@Test
	void testSelectByNo() throws Exception {
		Guest guest = guestDao.selectByNo(311);
		System.out.println(guest.getGuest_homepage());
	}
/*
	@Transactional
	@Test
	void testInsertGuest() throws Exception {
		Guest guest = new Guest(0,"test",new Date(),"test@test.com","test.com","테스트","테스트");
		assertEquals(guestDao.insertGuest(guest),1);
	}
	@Transactional
	@Test
	void testUpdateGuest() throws Exception {
		Guest guest = new Guest(450,"update",new Date(),"update","update","테스트","테스트");
		assertEquals(guestDao.updateGuest(guest), 1);
	}
	@Transactional
	@Test
	void testDeleteGuest() throws Exception {
		assertEquals(guestDao.deleteGuest(450), 1);
	}
*/
}
