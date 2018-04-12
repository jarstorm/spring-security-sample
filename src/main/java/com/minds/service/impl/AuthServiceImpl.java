package com.minds.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.minds.bean.CustomUser;
import com.minds.dao.UserRepository;
import com.minds.service.AuthService;

@Service("authService")
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;

	@Override	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUser user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}		
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

}
