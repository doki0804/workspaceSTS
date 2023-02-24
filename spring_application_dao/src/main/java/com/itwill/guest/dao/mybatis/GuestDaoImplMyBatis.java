package com.itwill.guest.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestDaoImplMyBatis implements GuestDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Guest> selectAll() throws Exception {
		return sqlSession.selectList("selectAll");
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		return sqlSession.selectOne("selectByNo",no);
	}

	@Override
	public int insertGuest(Guest guest) throws Exception {
		return sqlSession.insert("insertGuest",guest);
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		return sqlSession.update("updateGuest",guest);
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		return sqlSession.delete("deleteGuest",no);
	}
			
}
