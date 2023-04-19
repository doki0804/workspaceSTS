package com.itwill.ilhajob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itwill.ilhajob.user.entity.User;


@SpringBootApplication(scanBasePackageClasses = 
	{User.class, Corp.class,CorpImage.class,
	 App.class, Recruit.class, Cv.class,
	 Edu.class, Exp.class, Awards.class,
	 Review.class, Blog.class})
public class FinalProjectTeam1IlhajobApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectTeam1IlhajobApplication.class, args);
		System.out.println("통합테스트");
	}

}
