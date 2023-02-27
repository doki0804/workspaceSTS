package com.mybatis3.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.basic.SpringBootMyBatisFlowMain;
import com.mybatis3.domain.Student;

@SpringBootApplication
@MapperScan(basePackages = "com.mybatis3.dao.mapper")
public class SpringBootStudentDaoJOINSELECTMain {
	public static void main(String[] args) {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootStudentDaoJOINSELECTMain.class, args);
		StudentDao studentDao = (StudentDao)appicationContext.getBean(StudentDao.class);

		System.out.println("---------findStudentNameById-------------------------");
		System.out.println(studentDao.findStudentByIdWithAddress(1));
		System.out.println(studentDao.findStudentByIdWithAddress(7));
		System.out.println("---------findStudentNameList-------------------------");
		System.out.println(studentDao.findStudentByIdWithCourses(1));
		System.out.println(studentDao.findStudentByIdWithAddressWithCourses(1));
		System.out.println("---------findStudentByIdResultMap--------------------");
		System.out.println("---------findAllStudentsResultMap--------------------");
		
	}
}
