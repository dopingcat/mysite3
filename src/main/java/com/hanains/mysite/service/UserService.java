package com.hanains.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.mysite.dao.UserDao;
import com.hanains.mysite.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public void join(UserVo vo) {
		userDao.insert(vo);
	}

	public UserVo login(UserVo vo) {
		return userDao.get(vo);
	}

	public UserVo getUser(String email) {
		return userDao.get(email);
	}
}
