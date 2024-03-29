package com.springboot.security.oauth.user.service;

import java.util.List;

import com.springboot.security.oauth.user.dto.CvDto;


public interface CvService {
	
	// save
	CvDto saveCv(CvDto cvDto);
	
	// update
	CvDto updateCv(Long id, CvDto cvDto);
	
	// remove by cv id
	void removeById(Long id);
	
	// find cv by cv id
	CvDto findCvById(Long id);
	
	// find cv by user id
	List<CvDto> findByUserId(Long userId);
	
	// find all
	List<CvDto> findCvAll();
	
}
