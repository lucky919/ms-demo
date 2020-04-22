package com.learn.ms.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.learn.ms.dto.UserDTO;

public interface IUserService extends UserDetailsService {

	UserDTO registerUser(UserDTO userDetails);
	
	UserDTO getUserByEmail(String email);
}
