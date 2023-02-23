package com.itwill.guest;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class GuestDaoImplTest {
	@Autowired
	private GuestDao guestDao;
	
	@Disabled
	@Test
	void testSelectAll() throws Exception {
		assertNotEquals(guestDao.selectAll(), null);
		assertNotEquals(guestDao.selectAll().size(), 0);
	}
	@Test
	void testSelectByNo() throws Exception {
		assertNull(guestDao.selectByNo(123212));
		assertNotNull(guestDao.selectByNo(196));
		assertEquals(guestDao.selectByNo(196).getGuest_name(), "요셉짱");
	}
	
	@Test
	void testInsertGuest() throws Exception {
		Guest insertGuest=
				new Guest(0,"테스트",null,"test@gmail.com","test.com","타이틀","컨텐츠");
		assertEquals(guestDao.insertGuest(insertGuest), 1);
	}
	@Test
	void testUpdateGuest() throws Exception {
		Guest updateGuest=
				new Guest(242,"테스트수정",null,"testchange@gmail.com","testchange.com","타이틀수정","컨텐트수정");
		int updateRowCount = guestDao.updateGuest(updateGuest);
		if(updateRowCount!=1) {
			fail("update 실패");
		}
	}
	
	/*
	 * 
	 * 
	 * @Test void testDeleteGuest() { fail("Not yet implemented"); }
	 */
}
