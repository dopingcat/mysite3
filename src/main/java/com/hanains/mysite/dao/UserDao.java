package com.hanains.mysite.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanains.mysite.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;
	
	public UserVo get(UserVo vo) {
		return sqlSession.selectOne("user.selectByEmailAndPassword", vo);
	}

	public void insert(UserVo vo) {
		sqlSession.insert("user.insert", vo);
	}

	public UserVo get(String email) {
		return sqlSession.selectOne("user.selectByEmail", email);
	}
}