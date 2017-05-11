package info.nguyentai.springmvcdemo.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import info.nguyentai.springmvcdemo.model.Student;
import info.nguyentai.springmvcdemo.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	
	private Validator validator;
	
	public StudentController()
    {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
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
	public String addStudent(@ModelAttribute("student") Student student, Model model, BindingResult bindingResult) {
		logger.info("Creating student");
		 Set<ConstraintViolation<Student>> violations = validator.validate(student);
	     
		    for (ConstraintViolation<Student> violation : violations) 
		    {
		        String propertyPath = violation.getPropertyPath().toString();
		        String message = violation.getMessage();
		        bindingResult.addError(new FieldError("student",propertyPath,
		                               "Invalid input value: "+ propertyPath + " " + message + "! Please correct the error."));
		    }
		if(bindingResult.hasErrors()) {
			return "add-student";
		}
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