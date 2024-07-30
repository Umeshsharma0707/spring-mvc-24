package com.spring.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.StudentDao;
import com.spring.mvc.models.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	
	
	
	public StudentDao getStudentDao() {
		return studentDao;
	}



	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}



	public int insertStudent(Student student) {
		return this.studentDao.insertStudent(student);
		
	}
	
	public List<Student> getStudents(){
		return this.studentDao.getAllStudents();
	}
	
	// get student
	public Student getStudent(int rollNo) {
		return this.studentDao.getStudent(rollNo);
	}
}
