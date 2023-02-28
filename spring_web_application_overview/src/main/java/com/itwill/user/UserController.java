package com.itwill.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/user_list")
	public String List(HttpServletRequest request) {
		System.out.println("/list-->UserController.list()");
		List<User> userList= userService.list();
		request.setAttribute("userList", userList);
		return "forward:/WEB-INF/views/user_list.jsp";
	}
	
}
