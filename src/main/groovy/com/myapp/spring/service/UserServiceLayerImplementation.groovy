package com.myapp.spring.service

import org.springframework.stereotype.Service

import com.myapp.spring.domain.User
import com.myapp.spring.repository.UserDatabase

@Service
class UserServiceLayerImplementation implements UserServiceLayer{

	private UserDatabase userdatabase
	
	public UserServiceLayerImplementation(UserDatabase userdatabase) {
		this.userdatabase = userdatabase
	}

	@Override
	public User saveUser(User user) {
		userdatabase.save(user)
	}

	@Override
	public User findById(String userId) {
		userdatabase.findByUserId(userId)
	}
	
}
