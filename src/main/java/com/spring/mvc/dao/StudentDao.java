package com.spring.mvc.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.models.Student;

@Repository
public class StudentDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int insertStudent(Student student) {
		
		int result = (int)this.hibernateTemplate.save(student);
		
		return result;
	}
	public List<Student> getAllStudents(){
		
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		
		return students;
	}
	public Student getStudent(int rollNo) {
		Student student = this.hibernateTemplate.get(Student.class, rollNo);
		return student;
	}
}
