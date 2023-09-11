package com.myapp.spring.service
import org.springframework.stereotype.Service

import com.myapp.spring.domain.Course
import com.myapp.spring.repository.CoursesDatabase


@Service
class CourseServiceLayerImplementation implements CourseServiceLayer {

	private CoursesDatabase database
	
	public CourseServiceLayerImplementation(CoursesDatabase database) {
		this.database = database
	}
	
	@Override
	public List<Course> findAll() {
		database.findAll()
	}

	@Override
	public Course findById(String courseId) {
		database.findByCourseId(courseId)
	}

	@Override
	public Course saveCourse(Course course) {
		database.save(course)
	}
}
