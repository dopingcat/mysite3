package com.hanains.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.mysite.dao.GuestbookDao;
import com.hanains.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	@Autowired
	private GuestbookDao guestbookDao;
	
	public List<GuestbookVo> getList() {
		return guestbookDao.getList();
	}
	
	public List<GuestbookVo> getPageList(Long pageNum) {
		return null;
	}
	
	public void writeGuestbook(GuestbookVo vo) {
		guestbookDao.insert(vo);
	}
	
	public void deleteGuestbook(GuestbookVo vo) {
		guestbookDao.delete(vo);
	}
}
