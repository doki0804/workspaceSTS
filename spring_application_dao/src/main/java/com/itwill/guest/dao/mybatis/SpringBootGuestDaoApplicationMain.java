package com.itwill.guest.dao.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootGuestDaoApplicationMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext =SpringApplication.run(SpringBootGuestDaoApplicationMain.class, args);
		GuestDao guestDao=(GuestDao)applicationContext.getBean(GuestDao.class);
		System.out.println(guestDao.selectByNo(264));
	}
}
