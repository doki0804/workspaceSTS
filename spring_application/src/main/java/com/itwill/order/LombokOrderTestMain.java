package com.itwill.order;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
public class LombokOrderTestMain {
	public static void main(String[] args) {
		Order order = new Order();
		order.setOrderNo(1);
		order.setOrderTitle("TV외...");
		order.setOrderDate(new Date());
		System.out.println(order);
		Order order2 = new Order(2,"PHONE외..",new Date());
		System.out.println(order2);
		
	}
}
