package com.itwill.user.dao.mybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/*
 사용자관리에서 데이타베이스와의 작업을 전담하는 클래스
 USERINFO 테이블에 사용자를 추가,삭제,검색,수정등의 작업을한다.
 */
@Repository
public class UserDaoImplMyBatis implements UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int create(User user) throws Exception {
		return sqlSession.insert("create",user);
	}

	@Override
	public int update(User user) throws Exception {
		return sqlSession.update("update",user);
	}

	@Override
	public int remove(String userId) throws Exception {
		return sqlSession.delete("remove",userId);
	}

	@Override
	public User findUser(String userId) throws Exception {
		return sqlSession.selectOne("findUser", userId);
	}

	@Override
	public List<User> findUserList() throws Exception {
		return sqlSession.selectList("findUserList");
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		return false;
	}
	
}
