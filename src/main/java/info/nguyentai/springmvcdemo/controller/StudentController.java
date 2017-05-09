package info.nguyentai.springmvcdemo.controller;

import java.util.List;

import info.nguyentai.springmvcdemo.Service.StudentService;
import info.nguyentai.springmvcdemo.model.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/students")
@Controller
public class StudentController {
	private static final Logger logger = LoggerFactory
			.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.GET)
	public String getAllStudents(Model model) {
		logger.info("Get all students");
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		return "students";
	}

	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String addStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "add-student";
	}

	@RequestMapping(params = "form", method = RequestMethod.POST)
	public String addStudent(Student student, Model model, BindingResult bindingResult) {
		logger.info("Creating student");
		if(bindingResult.hasErrors()) {
			model.addAttribute("message", "Adding student failed while binding result!");
			model.addAttribute("addresult", "failed");
			return "add-result";
		}
		if(!studentService.addStudent(student)) {
			model.addAttribute("message", "Adding student failed!");
			model.addAttribute("addresult", "failed");
			return "add-result";
		}
		
		model.addAttribute("message", "Adding student successfully!");
		model.addAttribute("addresult", "successful");
		return "add-result";
	}
}