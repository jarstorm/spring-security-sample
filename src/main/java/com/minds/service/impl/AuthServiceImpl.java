package com.minds.service.impl;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.minds.service.AuthService;

@Service("authService")
public class AuthServiceImpl implements AuthService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (!"test".equals(username)) {
			throw new UsernameNotFoundException(username);
		}
		return new User(username, BCrypt.hashpw("test", BCrypt.gensalt(12)), new ArrayList<>());
	}

}
