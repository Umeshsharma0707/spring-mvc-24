package com.spring.mvc.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.dao.StudentDao;
import com.spring.mvc.models.Student;
import com.spring.mvc.services.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(path = "processForm", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute Student student, Model model) {
		
		
		List<Student> students = this.studentService.getStudents();
		
		Set<Integer> allRollNo = new HashSet<Integer>();
		
		for(Student s : students) {
			allRollNo.add(s.getRollNo());
		}
		
		if(allRollNo.contains(student.getRollNo())) {
			String msg = student.getStudentName() + " is already present at roll No : " + student.getRollNo();
			model.addAttribute("msg",msg);
		}else {
			int insertStudent = this.studentService.insertStudent(student);
			System.out.println("student inserted");
			System.out.println(insertStudent);
			
			System.out.println(student.toString());
			
			model.addAttribute("msg","student is inserted");
		}
		
		/*int rollNo = student.getRollNo();
		Boolean isPresent = false;
		for(Student s : students) {
			if(s.getRollNo() == rollNo) {
				isPresent = true;
			}
		}
		
		if(isPresent == true) {
			String msg = student.getStudentName() + " is already present at roll No : " + student.getRollNo();
			model.addAttribute("msg",msg);
		}else {
			int insertStudent = this.studentService.insertStudent(student);
			System.out.println("student inserted");
			System.out.println(insertStudent);
			
			System.out.println(student.toString());
			
			model.addAttribute("msg","student is inserted");
			
		}
		*/
		
		return "index";
	}
	
}
