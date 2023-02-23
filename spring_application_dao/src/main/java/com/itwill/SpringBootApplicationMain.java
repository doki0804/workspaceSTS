package com.itwill;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootApplicationMain {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootApplicationMain.class, args);
	}
}
