package com.example.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.model.CourseModel;

public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Override
	public CourseModel selectCourse(String id) {
		CourseModel course = 
				restTemplate.getForObject(
						"http://localhost:8080/rest/course/view/"+id, 
						CourseModel.class);
		return course;
	}

	@Override
	public List<CourseModel> selectAllCourses() {
		ResponseEntity<CourseModel[]> response = 
				restTemplate.getForEntity(
						"http://localhost:8080/rest/course/viewall", CourseModel[].class);
		CourseModel[] courses = response.getBody();
		return Arrays.asList(courses);
	}

}
