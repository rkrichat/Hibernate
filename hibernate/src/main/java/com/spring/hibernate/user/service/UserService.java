package com.spring.hibernate.user.service;

import com.spring.bean.UserInformation;

public interface UserService {
	public String getUserDetail(String id);
	public String updateUserDetail(UserInformation bean);
	public String createUser(UserInformation bean);
	public String deleteUser(UserInformation bean);
}
