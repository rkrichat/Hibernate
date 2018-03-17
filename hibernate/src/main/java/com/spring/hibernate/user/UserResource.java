package com.spring.hibernate.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.bean.UserInformation;
import com.spring.hibernate.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String getUserDetail(@RequestParam String id) {
		return userService.getUserDetail(id);
	}
	
	@PostMapping
	public String updateUserDetail(@RequestBody UserInformation bean) {
		return userService.updateUserDetail(bean);
	}
	
	@PutMapping
	public String createUser(@RequestBody UserInformation bean) {
		return userService.createUser(bean);
	}
	
	@DeleteMapping
	public String deleteUser(@RequestBody UserInformation bean) {
		return userService.deleteUser(bean);
	}
}
