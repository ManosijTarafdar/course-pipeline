package com.myapp.spring.repository

import org.springframework.data.mongodb.repository.MongoRepository
import com.myapp.spring.domain.Course

interface CoursesDatabase extends MongoRepository<Course,String> {
	
	Course findByCourseId(String courseId)
}
