package com.itwill2.bean.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.guest.GuestService;
import com.itwill.user.UserService;
import com.itwill1.bean.SpringBootApplicationMain;

@SpringBootApplication
@ComponentScan({"com.itwill.guest","com.itwill.user"})
public class SpringBootBeanDependencyInjectionMain {
	public static void main(String[] args) throws Exception {
		System.out.println("--------Spring Container초기화시작[ApplicationContext객체생성시작]--------");
		ApplicationContext applicationContext = SpringApplication.run(SpringBootApplicationMain.class, args);
		System.out.println("--------Spring Container초기화 끝 [ApplicationContext객체생성  끝]--------");
		System.out.println("--------Constructor Injection--------");
		GuestService guestService = applicationContext.getBean(GuestService.class);
		guestService.selectAll();
		System.out.println("--------Setter Injection--------");
		UserService userService = applicationContext.getBean(UserService.class);
		userService.create(null);
		
	}
}
