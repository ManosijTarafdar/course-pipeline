package com.myapp.spring.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import groovy.transform.ToString


@Document(collection="coursedatabase")
@ToString
class Course {
	
	@Id
	String id
	
	String courseId
	
	String courseName
	
	String courseDescription
	
}
