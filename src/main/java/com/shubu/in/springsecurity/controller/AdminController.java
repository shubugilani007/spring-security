package com.shubu.in.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubu.in.springsecurity.model.User;
import com.shubu.in.springsecurity.repository.UserRepository;

/**
 * 
 * @author Shoaib
 *
 */
@RestController
@RequestMapping("/secure/auth")
public class AdminController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/admin/add")
	public String addUser(@RequestBody User user) {
		String pwd = user.getPassword();
		String encrptedPwd = passwordEncoder.encode(pwd);
		user.setPassword(encrptedPwd);
		userRepository.save(user);
		return "User Created Successfully";
	}

}