package com.app.Springbootjpademo.jwt;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.app.Springbootjpademo.exception.DataNotFoundException;
@Service
public class JwtUserDetailsService implements UserDetailsService{
	@Override
	public UserDetails loadUserByUsername(String username) throws DataNotFoundException {
		if ("swapnil".equals(username)) {
			return new User("swapnil", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new DataNotFoundException("User not found with username: " + username);
		}
	}
}
