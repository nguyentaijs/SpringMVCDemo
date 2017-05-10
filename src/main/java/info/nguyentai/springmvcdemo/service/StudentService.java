package info.nguyentai.springmvcdemo.service;

import info.nguyentai.springmvcdemo.dao.StudentDAO;
import info.nguyentai.springmvcdemo.model.Student;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}
	
	public boolean addStudent(Student student) {
		if(checkDuplicate(student)) {
			return false;
		}
		studentDAO.addStudent(student);
		return true;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	private boolean checkDuplicate(Student student) {
		for (Student st : studentDAO.getAllStudents()) {
			if(st.getId().equals(student.getId())) {
				return true;
			}
		}
		return false;
	}
	
}
