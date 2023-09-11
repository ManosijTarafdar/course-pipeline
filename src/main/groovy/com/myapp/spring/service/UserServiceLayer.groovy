package com.myapp.spring.service

import com.myapp.spring.domain.User

interface UserServiceLayer {
	
	User saveUser(User user)
	
	User findById(String userId)
	
}
