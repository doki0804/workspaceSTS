package com.mybatis3.dao;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis3.dao.mapper.TutorMapper;
import com.mybatis3.domain.Tutor;

@Repository
public class TutorDao {
	
	 @Autowired private TutorMapper tutorMapper;
	  
	 public Tutor findTutorByIdWithCourses(Integer tutorId) {
		 return tutorMapper.findTutorByIdWithCourses(tutorId); }

	
}
