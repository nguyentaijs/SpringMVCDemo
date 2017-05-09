package info.nguyentai.springmvcdemo.Service;

import info.nguyentai.springmvcdemo.model.Student;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	private List<Student> students = new ArrayList<Student>();
	
	public List<Student> getAllStudents() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1993);
		cal.set(Calendar.MONTH, Calendar.MAY);
		cal.set(Calendar.DAY_OF_MONTH, 24);
		Date date = cal.getTime();
		students.add(new Student("st1", "Nguyen Van A", date));
		students.add(new Student("st2", "Nguyen Van B", date));
		students.add(new Student("st3", "Nguyen Van C", date));
		return students;
	}
	
	public boolean addStudent(Student student) {
		students.add(student);
		return true;
	}
}
