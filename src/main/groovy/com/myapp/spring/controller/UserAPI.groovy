package com.myapp.spring.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import com.myapp.spring.domain.User
import com.myapp.spring.service.UserServiceLayer

@RestController
@RequestMapping("/account")
class UserAPI {
	
	private UserServiceLayer UserServiceLayer

	public UserAPI(UserServiceLayer UserServiceLayer) {
		this.UserServiceLayer = UserServiceLayer
	}
	
	@GetMapping("/{userId}")
	def getUser(@PathVariable String userId) {
		UserServiceLayer.findById(userId)
	}
	
	@PostMapping("/buy")
	def buyCourse(@RequestBody Map<String, String> json) {
		def userId = json.get("userId")
		def courseId = json.get("courseId")
		User user = UserServiceLayer.findById(userId)
		user.enrolledCourses.add(courseId)
		UserServiceLayer.saveUser(user)
		"{'status':'Course Enrolled'}"
	}
	
	
	@PostMapping("/signup")
	def createNewUser(@RequestBody User user) {
		UserServiceLayer.saveUser(user)
	}
	
	@PostMapping("/signin")
	def verifyUser(@RequestBody Map<String, String> json) {
		def userId = json.get("userId")
		def password = json.get("password")
		User user = UserServiceLayer.findById(userId)
		Map<String, String> response = new HashMap()
		if(user.password == password) {
			response.put("status", "User Authenticated")
			response
		}
		else {
			response.put("status", "Invalid Credentials")
			response
		}
	}
}
