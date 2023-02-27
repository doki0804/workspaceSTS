package com.mybatis3.dao.mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mybatis3.domain.Tutor;

public interface TutorMapper {

	 public Tutor findTutorByIdWithCourses(Integer tutorId);
	
}
