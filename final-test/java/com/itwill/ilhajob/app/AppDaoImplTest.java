package com.itwill.ilhajob.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.ilhajob.app.mapper.AppMapper;

@SpringBootTest
@MapperScan(basePackages = "com.itwill.ilhajob")
class AppDaoImplTest {
	
	@Autowired
	private AppMapper appMapper; 	
	@Autowired
	private AppDao appDao;
	
	@Test
	void testFindAppByUserSeq() {
		System.out.println(appDao.findAppByUserSeq(2));
	}

}
