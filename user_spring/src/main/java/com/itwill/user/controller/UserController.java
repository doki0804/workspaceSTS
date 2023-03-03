package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.IdNotFoundException;
import com.itwill.user.exception.PasswordMismatchException;
/*
 * /user_main 
 * /user_write_form 
 * /user_write_action 
 * /user_login_form
 * /user_login_action 
 * /user_logout_action 
 * /user_view /user_modify_form
 * /user_modify_action 
 * /user_remove_action
 */
@Controller
@SessionAttributes("sUserId")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user_main")
	public String user_main() {
		return "user_main";
	}
	
	@GetMapping("/user_write_form")
	public String user_write_form(Model model, User user) {
		model.addAttribute("fuser",user);
		String forward_path = "user_write_form";
		return forward_path;
	}
	
	@PostMapping("/user_write_action")
	public String user_write_action_post(Model model,@ModelAttribute("fuser") User user) throws Exception {
		String forward_path = "";
		try {
			userService.create(user);
			forward_path = "redirect:/user_login_form";
			
		}catch (ExistedUserException e) {
			forward_path = "user_write_form";
			model.addAttribute("msg",e.getMessage());
			//model.addAttribute("fuser",user);
		}
		
		return forward_path;
	}

	@GetMapping("/user_login_form")
	public String user_login_form(@ModelAttribute("fuser") User user) {
		return "user_login_form";
	}

	@PostMapping("/user_login_action")
	public String user_login_action(Model model,@ModelAttribute("fuser") User user) throws Exception {
		String forwardPath = "";
		try {
			userService.login(user.getUserId(), user.getPassword());
			model.addAttribute("sUserId",user.getUserId());
			forwardPath = "redirect:user_main";
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg1",e.getMessage());
			forwardPath = "user_login_form";
		}catch (PasswordMismatchException e) {
			e.printStackTrace();
			model.addAttribute("msg2",e.getMessage());
			forwardPath = "user_login_form";
		}
		return forwardPath;
	}
	
	@GetMapping("/user_view")
	public String user_view(@ModelAttribute("sUserId")String sUserId,Model model) throws Exception {
		String forwardPath = "user_view";
		/************** login check **************/
		if(sUserId==null || sUserId=="") {
			return forwardPath = "redirect:/user_login";
		}
		model.addAttribute("loginUser",userService.findUser(sUserId));
		return forwardPath;
	}

	@PostMapping("user_modify_form")
	public String user_modify_form_post(@ModelAttribute("sUserId")String sUserId,Model model) throws Exception {
		String forwardPath = "user_modify_form";
		/************** login check **************/
		if(sUserId==null || sUserId=="") {
			return forwardPath = "redirect:/user_login";
		}
		model.addAttribute("loginUser",userService.findUser(sUserId));
		return forwardPath;
	}

	@PostMapping("/user_modify_action")
	public String user_modify_action_post(@ModelAttribute("sUserId")String sUserId,User user) throws Exception {
		String forwardPath = "";
		/************** login check **************/
		if(sUserId==null || sUserId=="") {
			return forwardPath = "redirect:/user_login";
		}
		int rowCount = userService.update(user);
		if(rowCount==1) {
			forwardPath = "redirect:/user_view";
		}else {
			forwardPath = "user_modify_form";
		}
		return forwardPath;
	}

	@PostMapping("user_remove_action")
	public String user_remove_action_post(@ModelAttribute("sUserId")String sUserId,SessionStatus sessionStatus) throws Exception {
		String forwardPath = "user_main";
		/************** login check **************/
		if(sUserId==null || sUserId=="") {
			return forwardPath = "redirect:/user_login";
		}
		userService.remove(sUserId);
		sessionStatus.setComplete();
		return forwardPath;
	}

	@GetMapping("user_logout_action")
	public String user_logout_action(@ModelAttribute("sUserId")String sUserId,SessionStatus sessionStatus) {
		String forwardPath = "redirect:/user_main";
		/************** login check **************/
		if(sUserId==null || sUserId=="") {
			return forwardPath = "redirect:/user_login";
		}
		sessionStatus.setComplete();
		return forwardPath;
	}
	
	@GetMapping(value =  {"/user_write_action","/user_login_action", "user_remove_action",
						  "/user_modify_action"})
	public String user_action_get() {
		String forwardPath = "redirect:/user_main";
		return forwardPath;
	}

	/*****************Local Exception Handler*******************/
	@ExceptionHandler(Exception.class)
	public String user_exception_handler(Exception e) {
		return "user_error";
	}
	


}
