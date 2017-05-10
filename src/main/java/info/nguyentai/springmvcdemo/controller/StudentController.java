package info.nguyentai.springmvcdemo.controller;

import java.util.List;

import info.nguyentai.springmvcdemo.model.Student;
import info.nguyentai.springmvcdemo.service.StudentService;
import info.nguyentai.springmvcdemo.validator.FormValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/students")
@Controller
public class StudentController {
	private static final Logger logger = LoggerFactory
			.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;

	@Autowired
	private FormValidator formValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(formValidator);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAllStudents(Model model) {
		logger.info("Get all students");
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		return "students";
	}

	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "add-student";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") @Validated Student student, Model model) {
		logger.info("Creating student");
//		if(bindingResult.hasErrors()) {
//			model.addAttribute("msg", "Adding student failed!");
//			model.addAttribute("css", "danger");
//			return "add-result";
//		}
		if(!studentService.addStudent(student)) {
			model.addAttribute("msg", "Adding student failed!");
			model.addAttribute("css", "danger");
			return "add-result";
		}
		model.addAttribute("css", "success");
		model.addAttribute("msg", "Student added successfully!");
		return "add-result";
	}
}