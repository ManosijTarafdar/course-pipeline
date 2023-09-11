package com.myapp.spring.service
import com.myapp.spring.domain.Course

interface CourseServiceLayer {
	
	List<Course> findAll()
	
	Course findById(String courseId)
	
	Course saveCourse(Course course)
	
}
