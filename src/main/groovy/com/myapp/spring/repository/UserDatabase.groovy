package com.myapp.spring.repository

import org.springframework.data.mongodb.repository.MongoRepository
import com.myapp.spring.domain.User

interface UserDatabase extends MongoRepository<User,String>{
	
	User findByUserId(String userId)
	
}
