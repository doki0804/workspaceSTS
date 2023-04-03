package com.itwill.ilhajob.awards;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.ilhajob.awards.mapper.AwardsMapper;
@SpringBootTest
class AwardsDaoImplTest {
	
	@Autowired
	private AwardsMapper awardsMapper;
	
	@Disabled
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	//@Test
	void testCreate() {
		Awards awards = Awards.builder().awardsSeq(5)
		.awardsName("정보화대회")
		.awardsDate(new java.util.Date())
		.awardsContent(null)
		.userSeq(3)
		.build();
		awardsMapper.insertAwards(awards);
	}
	@Disabled
	@Test
	void testUpdate() {
		Awards awards = Awards.builder().awardsSeq(7)
				.awardsName("정보화대회")
				.awardsDate(new java.util.Date())
		.awardsContent("내용")
		.userSeq(3)
		.build();
		
		awardsMapper.updateAwards(awards);
	}
	
	
	//@Test
	void testSelectAwardsByUser() {
		System.out.println(awardsMapper.selectByAwardsOfUser(3));
	}
	
	//@Test
	void testSelectAwards() {
		System.out.println(awardsMapper.selectByAwards(7));
	}
	//@Test
	void testRemove() {
		awardsMapper.removeAwardsBySeq(7);
	}
	
	@Test
	void testRemovebyUser() {
		awardsMapper.removeAwardsByUserSeq(3);
	}
	
	
}
