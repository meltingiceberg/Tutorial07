package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.dao.CourseDAO;
import com.example.model.CourseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
public class CourseServiceRest implements CourseService {

	@Autowired
	private CourseDAO courseDAO;
	
	@Override
	public CourseModel selectCourse(String id) {
		log.info("REST: course " + id + " selected");
		return courseDAO.selectCourse(id);
	}

	@Override
	public List<CourseModel> selectAllCourses() {
		log.info("REST: select all courses");
		return courseDAO.selectAllCourses();
	}

}
