package com.hanains.mysite.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanains.mysite.annotation.Auth;
import com.hanains.mysite.annotation.AuthUser;
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
	
	@Auth
	@RequestMapping("/modify/{no}")
	public String modify(@PathVariable("no") Long no, Model model) {
		BoardVo vo = boardService.viewContent(no);
		model.addAttribute("vo", vo);
		return "/board/modify";
	}
	
	@Auth
	@RequestMapping("/write")
	public String write() {
		return "/board/write";
	}
	
	@Auth
	@RequestMapping("/reply/{no}")
	public String reply(@PathVariable("no") Long no, Model model) {
		BoardVo vo = boardService.viewContent(no);
		System.out.println("reply : " + vo);
		model.addAttribute("vo", vo);
		return "/board/write";
	}
	
	@Auth
	@RequestMapping("/insert")
	public String insert(@AuthUser UserVo authUser, @ModelAttribute BoardVo vo) {
		vo.setMemberNo(authUser.getNo());
		boardService.writeBoard(vo);
		return "redirect:/board";
	}
	
	@Auth
	@RequestMapping("/update")
	public String update(@AuthUser UserVo authUser, @ModelAttribute BoardVo vo) {
		vo.setMemberNo(authUser.getNo());
		boardService.updateBoard(vo);
		
		return "redirect:/board";
	}
	
	@Auth
	@RequestMapping("/delete/{no}")
	public String delete(@AuthUser UserVo authUser, @PathVariable("no") Long no) {
		boardService.deleteBoard(no, authUser.getNo());
		
		return "redirect:/board";
	}
}