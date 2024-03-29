package com.springboot.security.oauth.corp.service;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;

import com.springboot.security.oauth.common.entity.App;
import com.springboot.security.oauth.common.repository.AppRepository;
import com.springboot.security.oauth.user.entity.User;
import com.springboot.security.oauth.user.repository.MessageRepository;
import com.springboot.security.oauth.user.repository.UserRepository;


@Service
public class EntityListenerTestService {
	@Autowired
	private AppRepository appRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private EntityManager entityManager;
	
	
	@Transactional
	public void createUserMessage() {
		User user=userRepository.findById(1L).get();
		App apply = App.builder()
				.appCreateDate(LocalDateTime.now())
				.appStatus(0)
				.cv(null)
				.recruit(null)
				.user(user)
				.build();
		appRepository.save(apply);
		
		
		
		
			
	}
}
