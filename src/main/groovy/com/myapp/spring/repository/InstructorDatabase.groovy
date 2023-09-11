package com.myapp.spring.repository

import org.springframework.data.mongodb.repository.MongoRepository
import com.myapp.spring.domain.Instructor

interface InstructorDatabase extends MongoRepository<Instructor,String>{
}
