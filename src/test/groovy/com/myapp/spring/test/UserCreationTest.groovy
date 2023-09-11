package com.myapp.spring.test

import static groovy.json.JsonOutput.toJson
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc

import com.fasterxml.jackson.databind.ObjectMapper
import com.myapp.spring.domain.User
import com.myapp.spring.service.UserServiceLayer

import spock.lang.Specification


@SpringBootTest
@AutoConfigureMockMvc
class UserCreationTest extends Specification {

   @Autowired
   MockMvc mvc
   
   @SpringBean
   UserServiceLayer userServiceLayer = Mock()
   
   @Autowired
   ObjectMapper objectMapper
   
   def "should pass User save details to domain component and return 'ok' status"() {
   
   given:
   
   User request = new User (
   
								userId: "Ankit2001",
								
								password: "Ankit2001",
								
								enrolledCourses: ["C001","C002"]
   
   							)
   
   and:
   
   userServiceLayer.saveUser(request)
   
   when:
   
   def response = mvc.perform(
   
				post('/account/signup').contentType(APPLICATION_JSON).content(toJson(request))
   
		).andReturn().response // notice the extra call to: andReturn()
   
   then:
   
   response.status == HttpStatus.OK.value()
   
   }

}