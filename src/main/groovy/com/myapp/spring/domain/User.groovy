package com.myapp.spring.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="userdatabase")
class User {
	
	@Id
	String id
	
	String userId
	
	String password
	
	List<String> enrolledCourses

}
