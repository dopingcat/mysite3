package com.hanains.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanains.mysite.service.UserService;
import com.hanains.mysite.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/joinform")
	public String joinform() {
		return "/user/joinform";
	}
	
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo vo) {
		userService.join(vo);
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "/user/joinsuccess";
	}
	
	@RequestMapping("/loginform")
	public String loginform(){
		return "/user/loginform";
	}

	@RequestMapping("/login")
	public String login(HttpSession session, @ModelAttribute UserVo vo) {
		UserVo authUser = userService.login(vo);
		if(authUser == null) {
			return "redirect:/user/loginform";
		}
		
		session.setAttribute("authUser", authUser);
		return "redirect:/";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}	
}