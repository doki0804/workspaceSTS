package com.itwill.guest.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
/*
 * web.xml설정을 대신할 클래스
 * 	- 톰캣실행시 기본설정
 */
public class WebAppInitConf implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class);
		ServletRegistration.Dynamic dynamic=servletContext.addServlet("Distpatcher", new DispatcherServlet(context));
		dynamic.setLoadOnStartup(0);
		dynamic.addMapping("/");
	}
	
}
