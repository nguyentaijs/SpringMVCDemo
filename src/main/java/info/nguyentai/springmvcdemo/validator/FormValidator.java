package info.nguyentai.springmvcdemo.validator;

import java.util.Date;

import info.nguyentai.springmvcdemo.Service.StudentService;
import info.nguyentai.springmvcdemo.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FormValidator implements Validator{

	@Autowired
	private StudentService studentService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Student student  = (Student) target;
		
		if(student.getId() == null || student.getId().trim().isEmpty()){
			errors.rejectValue("id", "NotEmpty.studentForm.id");
		}
		
		if(student.getId() == null || student.getId().trim().isEmpty()){
			errors.rejectValue("fullName", "NotEmpty.studentForm.name");
		}

		if(student.getDayOfBirth() == null) {
			errors.rejectValue("fullName", "NotEmpty.studentForm.dayOfBirth");
		} else if(student.getDayOfBirth().compareTo(new Date()) >= 0) {
			errors.rejectValue("fullName", "Invalid.studentForm.dayOfBirth");
		}
	}

	
}
