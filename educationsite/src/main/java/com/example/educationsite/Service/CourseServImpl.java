package com.example.educationsite.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.educationsite.Entity.CourseEntity;
import com.example.educationsite.Repository.CourseRepository;


@Service
public class CourseServImpl implements CourseService{

	
	@Autowired
	CourseRepository courseRepo;
	
	@Override
	public List<CourseEntity> getAllCourses() {
		return courseRepo.findAll();
	}

	@Override
	public void saveCourse(CourseEntity course) {
		courseRepo.save(course);
		
	}

	@Override
	public void deleteCourse(Integer id) {
		if(courseRepo.findById(id).isPresent()) {
			courseRepo.deleteById(id);
		}
		
	}

	@Override
	public CourseEntity updateCourse(CourseEntity updatedCourse) {
		if(courseRepo.findById(updatedCourse.getId()).isPresent()) {
			return courseRepo.save(updatedCourse);
		}
		return null;		
	}

	@Override
	public Optional<CourseEntity> findById(Integer id) {

		Optional<CourseEntity> entity= courseRepo.findById(id);
		return entity;
	}
	
	

	
	
}
