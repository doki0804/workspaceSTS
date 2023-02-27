package com.mybatis3.dao.mapper;

import com.mybatis3.domain.Tutor;

public interface TutorMapper {
	public Tutor findTutorByIdWithCourses(Integer tutorId);
}
