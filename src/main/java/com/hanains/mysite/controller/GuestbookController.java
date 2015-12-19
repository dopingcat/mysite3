package com.hanains.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanains.mysite.service.GuestbookService;
import com.hanains.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	@Autowired
	GuestbookService guestbookService;
	
	@RequestMapping("")
	public String list(Model model) {
		model.addAttribute("guestBookList", guestbookService.getList());
		return "/guestbook/list";
	}
	
	@RequestMapping("/write")
	public String write(@ModelAttribute GuestbookVo vo) {
		guestbookService.writeGuestbook(vo);
		return "redirect:/guestbook";
	}
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(@PathVariable("no") Long no, Model model){
		model.addAttribute("no", no);
		return "/guestbook/deleteform";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute GuestbookVo vo) {
		guestbookService.deleteGuestbook(vo);
		return "redirect:/guestbook";
	}
}