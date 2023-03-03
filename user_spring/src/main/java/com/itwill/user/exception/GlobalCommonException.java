package com.itwill.user.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalCommonException {

	@ExceptionHandler(Exception.class)
	public String hendlerException(Exception e) {
		return "user_error";
	}
}
