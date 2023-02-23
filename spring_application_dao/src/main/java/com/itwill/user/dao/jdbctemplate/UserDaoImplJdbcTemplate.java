package com.itwill.user.dao.jdbctemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/*
 사용자관리에서 데이타베이스와의 작업을 전담하는 클래스
 USERINFO 테이블에 사용자를 추가,삭제,검색,수정등의 작업을한다.
 */
@Repository
public class UserDaoImplJdbcTemplate implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int create(User user) throws Exception {
		return jdbcTemplate.update(UserSQL.USER_INSERT,user.getUserId(),user.getPassword(),user.getName(),user.getEmail());
	}

	@Override
	public int update(User user) throws Exception {
		return jdbcTemplate.update(UserSQL.USER_UPDATE,user.getPassword(),user.getName(),user.getEmail(),user.getUserId());
	}

	@Override
	public int remove(String userId) throws Exception {
		return jdbcTemplate.update(UserSQL.USER_REMOVE,userId);
	}

	@Override
	public User findUser(String userId) throws Exception {
		return jdbcTemplate.queryForObject(UserSQL.USER_SELECT_BY_ID, new Object[] {userId},new int[] {Types.VARCHAR},new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public List<User> findUserList() throws Exception {
		return jdbcTemplate.query(UserSQL.USER_SELECT_ALL, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		Map rowMap = jdbcTemplate.queryForMap(UserSQL.USER_SELECT_BY_ID_COUNT,userId);
		int existedUserResult =  Integer.parseInt(String.valueOf(rowMap.get("CNT")));
		if(existedUserResult==1) {
			return true;
		}else {
			return false;
		}
	}
	
}
