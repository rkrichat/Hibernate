package com.spring.hibernate.user.dao;

import com.spring.bean.UserInformation;

public interface UserDao {
	public String getUserDetail(String bean);
	public String updateUserDetail(UserInformation bean);
	public String createUser(UserInformation bean);
	public String deleteUser(UserInformation bean);
}
