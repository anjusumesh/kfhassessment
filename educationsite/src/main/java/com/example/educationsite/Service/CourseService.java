package com.example.educationsite.Service;

import java.util.List;
import java.util.Optional;

import com.example.educationsite.Entity.CourseEntity;

public interface CourseService {
	
	
	public List<CourseEntity> getAllCourses() ;
	
	public void saveCourse(CourseEntity course);
	
	public void deleteCourse(Integer id);
	
	public CourseEntity updateCourse(CourseEntity course);

	public Optional<CourseEntity> findById(Integer id);
}
