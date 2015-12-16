package com.hanains.mysite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanains.mysite.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestbookVo> getList() {
		return sqlSession.selectList("guestbook.selectAll");
	}
	
	public List<GuestbookVo> getPageList(Long pageNum) {
		return sqlSession.selectList("guestbook.selectByPage", pageNum);
	}
	
	public void insert(GuestbookVo vo) {
		sqlSession.insert("guestbook.insert", vo);
	}
	
	public void delete(GuestbookVo vo) {
		sqlSession.delete("guestbook.delete", vo);
	}
}
