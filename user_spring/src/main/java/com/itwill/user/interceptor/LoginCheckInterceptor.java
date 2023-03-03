package com.itwill.user.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		if(sUserId==null||sUserId=="") {
			String forwardPath = "redirect:user_main";
			request.setAttribute("forwardPath",forwardPath);
		}
		return true;
	}
}
