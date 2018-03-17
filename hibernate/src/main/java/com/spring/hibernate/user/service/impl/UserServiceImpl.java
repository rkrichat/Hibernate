package com.spring.hibernate.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bean.UserInformation;
import com.spring.hibernate.user.dao.UserDao;
import com.spring.hibernate.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public String getUserDetail(String id){
		return userDao.getUserDetail(id);
	}
	
	@Override
	public String updateUserDetail(UserInformation bean){
		return userDao.updateUserDetail(bean);
	}
	
	@Override
	public String createUser(UserInformation bean){
		return userDao.createUser(bean);
	}
	@Override
	public String deleteUser(UserInformation bean){
		return userDao.deleteUser(bean);
	}


}
