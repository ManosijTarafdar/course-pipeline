package com.myapp.spring.controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import com.myapp.spring.domain.Course
import com.myapp.spring.service.CourseServiceLayer

@RestController
@RequestMapping("/api")
class CourseAPI {
	
	private CourseServiceLayer CourseServiceLayer
	
	public CourseAPI(CourseServiceLayer CourseServiceLayer) {
		this.CourseServiceLayer = CourseServiceLayer
	}

	@GetMapping("/courses")
	def findAllCourses() {
		CourseServiceLayer.findAll()
	}
	
	@GetMapping("/course/{courseId}")
	def Map<String, String> findCourseById(@PathVariable String courseId) {
		Course course = CourseServiceLayer.findById(courseId)
		Map<String, String> response = new HashMap()
		response.put("courseName",course.courseName)
		response.put("courseDescription", course.courseDescription)
		response
	}
	
	@PostMapping("/add")
	def addCourse(@RequestBody Course course) {
		CourseServiceLayer.saveCourse(course)
	}
}
