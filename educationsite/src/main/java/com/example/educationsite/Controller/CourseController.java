package com.example.educationsite.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.educationsite.Entity.CourseEntity;
import com.example.educationsite.Service.CourseServImpl;

@RestController
public class CourseController {
	
	@Autowired
	CourseServImpl cServ;
	
	public CourseController(CourseServImpl cServ) {
		this.cServ = cServ;
	}

	@GetMapping("/courses")
	public List<CourseEntity> getCourses(){
		
		return cServ.getAllCourses();
		
	}
	
	@PostMapping("/courses/add")
	public String addNewCourse(@RequestBody CourseEntity newCourse){
		
		cServ.saveCourse(newCourse);
		return "success";
	}
	@GetMapping("/courses/find/{id}")
	public Optional<CourseEntity> getCourseById(@PathVariable Integer id){
		return cServ.findById(id);
		
		
	}
	@RequestMapping(value="/courses/delete/{id}", method=RequestMethod.DELETE)
	public void deleteCourses(@PathVariable Integer id){
		
		cServ.deleteCourse(id);
		
	}
	
	@PostMapping("/courses/modify/{id}")
	public String editCourse(@RequestBody CourseEntity editedCourse){
		
		
		if(null != cServ.updateCourse(editedCourse)) {
			return "success";
		}
		return "failed";
	}
	
	
}
