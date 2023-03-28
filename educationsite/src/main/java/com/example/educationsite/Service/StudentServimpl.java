package com.example.educationsite.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.educationsite.Entity.StudentEntity;
import com.example.educationsite.ExceptionHandler.CustomExceptions;
import com.example.educationsite.Repository.StudentRepository;


@Service
public class StudentServimpl implements StudentService{

	
	
	@Autowired
	StudentRepository studRepo;
	
	@Override
	public List<StudentEntity> listAllStudents() {
		return studRepo.findAll();
				
	}

	@Override
	public void saveStudent(StudentEntity student) {
		studRepo.save(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		if(studRepo.findById(id).isPresent()) {
			studRepo.deleteById(id);
		}else {
			throw new CustomExceptions("Student does not exist");
		}
		
	}

	@Override
	public void updateStudent(StudentEntity modifiedStudent) {
		if(studRepo.findById(modifiedStudent.getId()).isPresent()) {
			studRepo.save(modifiedStudent);
		}else {
			throw new CustomExceptions("Student does not exist");
		}
		
	}

	@Override
	public List<StudentEntity> getStudentByCid(Integer cid) {
		List<StudentEntity> en = studRepo.getBycourseid(cid);
		return	en;
		
		
	}

}
