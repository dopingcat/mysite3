package com.hanains.mysite.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.mysite.dao.BoardDao;
import com.hanains.mysite.vo.BoardVo;

@Service
public class BoardService {
	private final int BLOCK_SIZE = 5;
	
	@Autowired
	private BoardDao boardDao;

	public Map<String, Object> getBoardListData(Long page, Long listSize, String keyword) {
		if(listSize < 1) {
			listSize = 5L;
		}
		//1. calculate pager's basic data
		long boardCount = boardDao.getBoardCount(keyword);
		long pageCount = (long)Math.ceil((double)boardCount / listSize);
		long blockCount = (long)Math.ceil((double)pageCount / BLOCK_SIZE);
		long currentBlock = (long)Math.ceil((double)page / BLOCK_SIZE);
		
		//2. page validation
		if(page < 1) {
			page = 1L;
			currentBlock = 1;
		} else if(page > pageCount) {
			page = pageCount;
			currentBlock = (int)Math.ceil((double)page / BLOCK_SIZE);
		}
		
		//3. calculate pager's data
		long begin = (currentBlock == 0)? 1 : (currentBlock - 1)*BLOCK_SIZE + 1;
		long end = (begin - 1) + BLOCK_SIZE;
		long prevBlock = (currentBlock > 1)? ((currentBlock - 1)*BLOCK_SIZE) : 0;
		long nextBlock = (currentBlock < blockCount)? (currentBlock*BLOCK_SIZE + 1) : 0;
		
		//4. fetch list
		List<BoardVo> list = boardDao.getList(page, listSize, keyword);
		
		//5. pack all information of list
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("currentPage", page);
		map.put("keyWord", keyword);
		map.put("firstItemIndex", boardCount-(page-1)*listSize);
		map.put("begin", begin);
		map.put("end", end);
		map.put("pageCount", pageCount);
		map.put("prevBlock", prevBlock);
		map.put("nextBlock", nextBlock);
		return map;
	}
	
	public BoardVo viewContent(Long no) {
		BoardVo vo = boardDao.getContent(no);
		boardDao.increaseViewCount(no);
		return vo;
	}
	
	public void writeBoard(BoardVo vo) {
		boardDao.insert(vo);
	}
	
	public void updateBoard(BoardVo vo) {
		boardDao.update(vo);
	}

	public void deleteBoard(Long no, Long memberNo) {
		boardDao.delete(no, memberNo);
	}
}