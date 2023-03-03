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
	public String user_write_action_post(Model model, User user) throws Exception {
		String forward_path = "";
		int insertRowCount = userService.create(user);
		if(insertRowCount==1) {
			return forward_path = "redirect:/user_login_form";
		}else {
			forward_path = "user_write_form";
			String msg = "아이디가 중복입니다.";
			model.addAttribute("msg",msg);
			model.addAttribute("fuser",user);
		}
		return forward_path;
	}

	@GetMapping("/user_login_form")
	public String user_login_form(Model model, User user) {
		model.addAttribute("fuser",user);
		String forward_path = "user_login_form";
		return forward_path;
	}

	@PostMapping("/user_login_action")
	public String user_login_action_post(Model model, User user) throws Exception {
		String forwardPath = "user_login_form";
		int rowCount = userService.login(user.getUserId(), user.getPassword());
		if(rowCount==2) {
			model.addAttribute("sUserId",user.getUserId());
			forwardPath = "redirect:/user_main";
		}else if(rowCount==1) {
			forwardPath = "user_login_form";
			String msg2 = "비밀번호가 불일치합니다";
			model.addAttribute("msg2",msg2);
			model.addAttribute("fuser",user);
		}else if(rowCount==0) {
			forwardPath = "user_login_form";
			String msg1 = "아이디가 존재하지 않습니다";
			model.addAttribute("msg1",msg1);
			model.addAttribute("fuser",user);
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


}
