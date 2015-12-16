package com.hanains.mysite.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanains.mysite.service.BoardService;
import com.hanains.mysite.vo.BoardVo;
import com.hanains.mysite.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("")
	public String list(
			@RequestParam(value="keyword", required = true, defaultValue = "") String keyword,
			@RequestParam(value="page", required = true, defaultValue = "1") Long page,
			@RequestParam(value="listSize", required = true, defaultValue = "5") Long listSize,	// 차후 보여질 개수 조절 기능에 사용
			Model model) {
		Map<String, Object> map = boardService.getBoardListData(page, listSize, keyword);
		model.addAttribute("boardData", map);
		return "/board/list";
	}
	
	@RequestMapping("/view/{no}")
	public String view(@PathVariable("no")Long no, Model model) {
		model.addAttribute("vo", boardService.viewContent(no));
		return "/board/view";
	}
	
	@RequestMapping("/modify/{no}")
	public String modify(HttpSession session, @PathVariable("no") Long no, Model model) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			return "redirect:/user/loginform";
		}
		BoardVo vo = boardService.viewContent(no);
		model.addAttribute("vo", vo);
		return "/board/modify";
	}
	
	@RequestMapping("/write")
	public String write(HttpSession session) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			return "redirect:/user/loginform";
		}
		return "/board/write";
	}
	
	@RequestMapping("/insert")
	public String insert(HttpSession session, @ModelAttribute BoardVo vo) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if( authUser == null ) {
			return "redirect:/user/loginform";
		}
		vo.setMemberNo(authUser.getNo());
		boardService.writeBoard(vo);
		
		return "redirect:/board";
	}
	
	@RequestMapping("/update")
	public String update(HttpSession session, @ModelAttribute BoardVo vo) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			return "redirect:/user/loginform";
		}
		vo.setMemberNo(authUser.getNo());
		boardService.updateBoard(vo);
		
		return "redirect:/board";
	}
	
	@RequestMapping("/delete/{no}")
	public String delete(HttpSession session, @PathVariable("no") Long no) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			return "redirect:/user/loginform";
		}
		boardService.deleteBoard(no, authUser.getNo());
		
		return "redirect:/board";
	}
}