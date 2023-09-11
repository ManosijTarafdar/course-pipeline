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
import com.myapp.spring.domain.Course
import com.myapp.spring.service.CourseServiceLayer

import spock.lang.Specification


@SpringBootTest
@AutoConfigureMockMvc
class CourseCreationTest extends Specification {

   @Autowired
   MockMvc mvc
   
   @SpringBean
   CourseServiceLayer courseServiceLayer = Mock()
   
   @Autowired
   ObjectMapper objectMapper
   
   def "should pass course save details to domain component and return 'ok' status"() {
   
   given:
   
   Course request = new Course (
   
								courseId: "C010",
								
								courseName: "Cloud Management",
								
								courseDescription: "This is a Cloud Course"
   
   								)
   
   and:
   
   courseServiceLayer.saveCourse(request)
   
   when:
   
   def response = mvc.perform(
   
				post('/api/add').contentType(APPLICATION_JSON).content(toJson(request))
   
		).andReturn().response // notice the extra call to: andReturn()
   
   then:
   
   response.status == HttpStatus.OK.value()
   
   }

}