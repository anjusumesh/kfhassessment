package com.example.educationsite.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.educationsite.Entity.StudentEntity;
import com.example.educationsite.Service.StudentServimpl;

@RestController
public class StudentController {

	@Autowired
	StudentServimpl stServ;
	
	
	public StudentController(StudentServimpl stServ) {
		this.stServ = stServ;
	}
	@GetMapping("/students")
	public List<StudentEntity> getStudents(){
		
		return stServ.listAllStudents();
		
		
	}
	
	@PostMapping("/students/add")
	public String addStudent(@RequestBody StudentEntity newCourse){
		
		stServ.saveStudent(newCourse);
		return "success";
	}
	@GetMapping("/students/getByCid/{cid}")
	public List<StudentEntity> getStudentByCId(@PathVariable Integer cid){
		return stServ.getStudentByCid(cid);
		
		
	}
	@RequestMapping(value="/students/delete/{id}", method=RequestMethod.DELETE)
	public void deleteStudent(@PathVariable Integer id){
		
		stServ.deleteStudent(id);
		
	}
	
	@PostMapping("/students/modify")
	public void editStudent(@RequestBody StudentEntity editedStudent){
		
		
		stServ.updateStudent(editedStudent);
		
	}
	
	
	
	
}
