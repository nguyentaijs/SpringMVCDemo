package info.nguyentai.springmvcdemo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import info.nguyentai.springmvcdemo.dao.StudentDAO;
import info.nguyentai.springmvcdemo.model.Student;

public class StudentServiceTest {
	
	private StudentService studentService;
	
	@Mock
	private StudentDAO studentDAO;
	
	@Before
	public void setup () {
		MockitoAnnotations.initMocks(this);
		studentService = new StudentService();
		studentService.setStudentDAO(studentDAO);
	}
	
	@Test
	public void testAddStudent_Success() {
		
		Student student = new Student("st1", "Student 1", new Date());
		Student anotherStudent = new Student("st2", "Student 2", new Date());
		when(studentDAO.getAllStudents()).thenReturn(Arrays.asList(anotherStudent));
		Boolean result = studentService.addStudent(student);
		verify(studentDAO, times(1)).addStudent(Mockito.any(Student.class));
		assertEquals(true, result);
	}
	
	@Test
	public void testAddStudent_Failure() {
		Student student = new Student("st1", "Student 1", new Date());
		Student anotherStudent = new Student("st2", "Student 2", new Date());
		when(studentDAO.getAllStudents()).thenReturn(Arrays.asList(student, anotherStudent));
		Boolean result = studentService.addStudent(student);
		verify(studentDAO, times(0)).addStudent(Mockito.any(Student.class));
		assertEquals(false, result);
	}
	
	
}
