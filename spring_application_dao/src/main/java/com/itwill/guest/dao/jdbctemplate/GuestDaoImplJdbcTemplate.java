package com.itwill.guest.dao.jdbctemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GuestDaoImplJdbcTemplate implements GuestDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Guest> selectAll() throws Exception {
		return jdbcTemplate.query(GuestSQL.GUEST_SELECT_ALL, new BeanPropertyRowMapper<Guest>(Guest.class));
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		return jdbcTemplate.queryForObject(GuestSQL.GUEST_SELECT_BY_NO, new Object[]{no},new int[] {Types.INTEGER},new BeanPropertyRowMapper<Guest>(Guest.class));
	}

	@Override
	public int insertGuest(Guest guest) throws Exception {
		return jdbcTemplate.update(GuestSQL.GUEST_INSERT,
				guest.getGuest_name(),guest.getGuest_email(),guest.getGuest_homepage(),guest.getGuest_title(),guest.getGuest_content());
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		return jdbcTemplate.update(GuestSQL.GUEST_UPDATE,
				guest.getGuest_name(),guest.getGuest_email(),guest.getGuest_homepage(),guest.getGuest_title(),guest.getGuest_content(),guest.getGuest_no());
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		return jdbcTemplate.update(GuestSQL.GUEST_DELETE,no);
	}
		
}
