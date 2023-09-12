package com.myapp.spring.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection="instructordatabase")
class Instructor {
	
	@Id
	String id
	
	String instructorId
	
	String password
	
	List<String> instructedCourses
}
