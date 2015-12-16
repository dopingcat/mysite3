package com.hanains.mysite.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanains.mysite.vo.BoardVo;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;
	
	public long getBoardCount(String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword );
		Long count = sqlSession.selectOne("board.selectCount", map);
		
		return count;
	}
	
	public List<BoardVo> getList(Long page, Long listSize, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("page", page);
		map.put("listSize", listSize);
		List<BoardVo> list = sqlSession.selectList("board.selectPageList", map);
		return list;
	}
	
	public Long getPageSize(String keyword) {
		return null;
	}
	
	public Long getTotalPageSize() {
		return null;
	}
	
	public BoardVo getContent(Long no) {
		return sqlSession.selectOne("board.selectByNo", no);
	}
	
	public void increaseViewCount(Long no) {
		
	}
	
	public void insert(BoardVo vo) {
		sqlSession.insert("board.insert", vo);
	}

	public void update(BoardVo vo) {
		System.out.println(vo);
		sqlSession.update("board.update", vo);
	}

	public void delete(Long no, Long memberNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("no", no);
		map.put("memberNo", memberNo);
		sqlSession.delete("board.delete", map);
	}
}