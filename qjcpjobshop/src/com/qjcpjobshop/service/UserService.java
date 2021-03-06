package com.qjcpjobshop.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.qjcpjobshop.dao.UserDao;
import com.qjcpjobshop.entity.Resume;
import com.qjcpjobshop.entity.Userfindjob;

@Service
public class UserService {
	@Resource
	private UserDao userDao;
	
	public Resume findP(String name) {
		return userDao.findP(name);
	}
	public void savep(Resume p, HttpSession session) {
		userDao.savep(p, session);
	}
	public void regist(Userfindjob user) {
		userDao.insert(user);
	}
	
	public Userfindjob findByName(String name){
		return userDao.findByName(name);
	}
	
	public Userfindjob login(String name,String password) {
		return userDao.selectByUsername(name, password);
	}
}
