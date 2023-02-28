package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingGETPOSTController {

	@GetMapping("/login")
	//@RequestMapping(method = RequestMethod.GET)
	public String get_login_form() {
		return "forward:/WEB-INF/views/get_login_form.jsp";
	}
	@PostMapping("/login")
	public String post_login_action() {
		
		return "";
	}
}
