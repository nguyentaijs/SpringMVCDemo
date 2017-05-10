package info.nguyentai.springmvcdemo.dao;

import java.util.List;

import info.nguyentai.springmvcdemo.model.Student;

public interface StudentDAO {
	public List<Student> getAllStudents();
	public void addStudent(Student student);
}
