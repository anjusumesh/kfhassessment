package com.example.educationsite.Service;

import java.util.List;

import com.example.educationsite.Entity.StudentEntity;

public interface StudentService {

	
	public List<StudentEntity> listAllStudents() ;
	
	public void saveStudent(StudentEntity student);
	
	public void deleteStudent(Integer id);
	
	public void updateStudent(StudentEntity student);
	
	public List<StudentEntity> getStudentByCid(Integer cid);
}
