package com.itwill.guest.dao.jdbctemplate;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootJdbcTemplateMain {
	public static void main(String[] args) throws Exception {
	
		ApplicationContext applicationContext =
				SpringApplication.run(SpringBootJdbcTemplateMain.class, args);
		JdbcTemplate jdbcTemplate =
				(JdbcTemplate)applicationContext.getBean(JdbcTemplate.class);
		System.out.println("1.JdbcTemplate : "+jdbcTemplate);
		System.out.println("2.JdbcTemplate DataSource : "+jdbcTemplate.getDataSource());
		System.out.println("2.JdbcTemplate DataSource Connection : "+jdbcTemplate.getDataSource().getConnection());
		System.out.println("1. Jdbctemplate객체얻기");
		/*********************************************************
		 * SELECT --> queryForObject 반환타입[String,wrapper,DTO]
		 *********************************************************/
		/*
		 * queryForObject 반환타입[DTO]
		 */
		String selectDtoSql="select * from guest where guest_no=?";
		Object[] paramArray1 = {263};
		Object[] paramArray2 = new Object[]{263};
		
		/*
		 <<BeanPropertyRowMapper 클래스>>
		 	ResultSet객체로부터 데이타를 컬럼이름으로 get해서
		 	DTO객체 생성 후 테이블컬럼이름과 동일한 이름의 DTO 객체의 property에 대입 
		 */
		BeanPropertyRowMapper<Guest> guestBeanPropertyRowMapper =
				new BeanPropertyRowMapper<Guest>(Guest.class);
		
		Guest guest = jdbcTemplate.queryForObject(selectDtoSql,
												  new Object[]{208},
												  new int[]{Types.INTEGER},
												  guestBeanPropertyRowMapper);
		System.out.println("queryForObject[Guest] : " + guest);
		/*****************************************
		 * SELECT --> query 반환타입[List<DTO>]
		 ****************************************/
		/*
		 * query[반환타입 List<Guest>]
		 */
		String selectDtoListSql="select * from guest";
		List<Guest> guestList = jdbcTemplate.query(selectDtoListSql, guestBeanPropertyRowMapper);
		System.out.println("query[guestList] : "+guestList);
		/*****************************************
		 * SELECT --> queryForList 반환타입[List<String,Wrapper>]
		 ****************************************/
		String selectStringListSql="select guest_name from guest";
		List<String> guest_nameList = jdbcTemplate.queryForList(selectStringListSql,String.class);
		System.out.println("--> queryForList[List<String>] : " + guest_nameList);
		/*****************************************
		 * SELECT --> queryForMap 반환타입[Map<String,Object>]
		 ****************************************/
		String selectMapSql = "select guest_no from guest where guest_no = ?";
		Map rowMap = jdbcTemplate.queryForMap(selectMapSql,264);
		System.out.println("--> queryForMap반환타입[Map] : "+rowMap);
		
		String selectMapListSql = "select * from guest";
		List rowMapList = jdbcTemplate.queryForList(selectMapListSql);
		System.out.println("--> queryForMap반환타입[Map] : "+rowMapList);
		/*
		 * DML(update,delete,insert) --> update 반환타입[rowCount(int)]
		 *
		 */
		String insertSql="insert into guest values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
		String updateSql="update guest set  guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no=?";
		String deleteSql="delete from guest where guest_no=?";
		
		/*
		int rowCount = jdbcTemplate.update(insertSql, new Object[]{"test","test@test.com","test.com","테스트","테스트"});
		System.out.println(rowCount);
		 * rowCount = jdbcTemplate.update(updateSql,
		 * "양념게장","update@test.com","update.com","업데이트","업데이트",208);
		 * System.out.println(rowCount);
		 * 
		 * rowCount = jdbcTemplate.update(deleteSql,209); System.out.println(rowCount);
		 */
		/*
		 * guestForObject 반환타입
		 */
		String selectStringSql = "select guest_name from guest where guest_no=?";
		String guest_name = jdbcTemplate.queryForObject(selectStringSql, new Object[]{264},new int[]{Types.INTEGER},String.class);
		System.out.println(guest_name);
		
		
		
		
		
	}
	
}
