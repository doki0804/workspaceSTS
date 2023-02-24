package com.mybatis3.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.basic.SpringBootMyBatisFlowMain;
import com.mybatis3.domain.Student;

@SpringBootApplication
public class SpringBootStudentDaoDMLMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootStudentDaoDMLMain.class, args);
		StudentDao studentDao = (StudentDao)appicationContext.getBean(StudentDao.class);

		System.out.println("--------------insertStudent(Dto)----------------------------");
		studentDao.insertStudent(new Student(1000,"도라에몽","test@test.com",new Date()));
		System.out.println("--------------insertStudentBySequence1----------------------");
		studentDao.insertStudentBySequence1(new Student(0,"시퀀스1","seq1@test.com",new Date()));
		System.out.println("--------------insertStudentBySequence2----------------------");
		Student student = new Student(0,"시퀀스2","seq2@test.com",new Date());
		studentDao.insertStudentBySequence2(student);
		System.out.println("### pk -->" + student.getStudId());
		System.out.println(studentDao.findStudentById(student.getStudId()));
		System.out.println("--------------updateStudentById-----------------------------");
		Student updateStudent=studentDao.findStudentById(7);
		updateStudent.setName("변경환");
		updateStudent.setEmail("update@update.com");
		updateStudent.setDob(new SimpleDateFormat("yyyy/MM/dd").parse("2000/02/02"));
		studentDao.updateStudentById(updateStudent);
		System.out.println("--------------deleteStudentById-----------------------------");
		studentDao.deleteStudentById(9);
		System.out.println("--------------deleteStudentByName---------------------------");
		studentDao.deleteStudentByName("도라에몽");
		System.out.println("--------------deleteStudentByNameLike-----------------------");
		
		
		
	}
}
