package com.itwill.guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
@Controller
public class GuestController {
	
	@Autowired
	private GuestService guestServeice;
	
	public GuestController() {
		System.out.println(">>>GuestController");
	}
	@RequestMapping("/guest_main")
	public String guest_main() {
		String forwardPath = "forward:/WEB-INF/views/guest_main.jsp";
		return forwardPath;
	}
	
	@GetMapping("/guest_list")
	public String guest_list(ModelMap modelMap) throws Exception {
		List<Guest> guestlist = guestServeice.selectAll();
		modelMap.addAttribute("guestList", guestlist);
		String forwardPath = "forward:/WEB-INF/views/guest_list.jsp";

		return forwardPath;
	}
	
	@GetMapping("/guest_error")
	public String guest_error() {
		String forwardPath = "forward:/WEB-INF/views/guest_error.jsp";

		return forwardPath;
	}
	
	@GetMapping("/guest_modify_action")
	public String guest_modify_action_get() {
		String forwardPath = "redirect:/guest_main";
		return forwardPath;
	}
	
	@PostMapping("/guest_modify_action")
	public String guest_modify_action(Guest guest) throws Exception {
		guestServeice.updateGuest(guest);
		String forwardPath = "redirect:guest_view?guest_no="+guest.guest_no;
		return forwardPath;
	}
	
	@GetMapping("/guest_modify_form")
	public String guest_modify_get() {
		String forwardPath = "redirect:guest_error";
		return forwardPath;
	}
	@PostMapping("/guest_modify_form")
	public String guest_modify_form(Guest guest) {
		String forwardPath = "forward:/WEB-INF/views/guest_modify_form.jsp";
		return forwardPath;
	}

	@GetMapping("guest_remove_action")
	public String guest_remove_action_get() {
		String forwardPath = "redirect:guest_error";
		return forwardPath;
	}

	@PostMapping("guest_remove_action")
	public String guest_remove_action(Guest guest) throws Exception {
		guestServeice.deleteGuest(guest.guest_no);
		String forwardPath = "redirect:guest_list";
		return forwardPath;
	}
	@GetMapping("/guest_view")
	public String guest_view(ModelMap modelMap, Guest guest) throws Exception {
		guest = guestServeice.selectByNo(guest.guest_no);
		modelMap.addAttribute("guest", guest);
		String forwardPath = "forward:/WEB-INF/views/guest_view.jsp";
		return forwardPath;
	}
	
	@GetMapping("/guest_write_action")
	public String guest_write_action_get() {
		String forwardPath = "redirect:guest_error";
		return forwardPath;
	}
	
	@PostMapping("/guest_write_action")
	public String guest_write_action(Guest guest) throws Exception {
		guestServeice.insertGuest(guest);
		String forwardPath = "redirect:guest_view?guest_no="+guest.guest_no;
		return forwardPath;
	}

	@GetMapping("/guest_write_form")
	public String guest_write() {
		String forwardPath = "forward:/WEB-INF/views/guest_write_form.jsp";
		return forwardPath;

	}

}
