package com.spring.mvc.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.mvc.dao.StudentDao;
import com.spring.mvc.models.Student;
import com.spring.mvc.services.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@ModelAttribute
	public void CommonDataForModel(Model model) {
		model.addAttribute("Heading", "Student Management");
		model.addAttribute("desc", "Home for students");
	}

	@RequestMapping(path = "processForm", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute Student student, Model model) {

		List<Student> students = this.studentService.getStudents();

		Set<Integer> allRollNo = new HashSet<Integer>();

		for (Student s : students) {
			allRollNo.add(s.getRollNo());
		}

		if (allRollNo.contains(student.getRollNo())) {
			String msg = student.getStudentName() + " is already present at roll No : " + student.getRollNo();
			model.addAttribute("msg", msg);
		} else {
			
			int insertStudent = this.studentService.insertStudent(student);
			System.out.println("student inserted");
			System.out.println(insertStudent);

			System.out.println(student.toString());

			// model.addAttribute("msg","student is inserted");
			model.addAttribute("student", student);
		}

		return "student-details";

	}
	
	// get single student
	
	@GetMapping("/student/{rollNo}")
	public String getSingleStudent(@PathVariable("rollNo") int rollNo, Model model) {
		
		Student student = this.studentService.getStudent(rollNo);
		if(student == null) {
			System.out.println("no data found");
			model.addAttribute("msg", "no data found");
		}
		else {
			System.out.println("name : "+ student.getStudentName());
			System.out.println("roll No : " + student.getRollNo());
			System.out.println("grade : " + student.getGrade());
			model.addAttribute("student", student);
		}
		return "single-student";
	}
	
	

}
