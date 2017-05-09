package info.nguyentai.springmvcdemo.model;

import java.util.Date;

public class Student {
	private String id;
	private String fullName;
	private Date dayOfBirth;
	
	public Student() {
		
	}
	
	public Student(String id, String fullName, Date dayOfBirth) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dayOfBirth = dayOfBirth;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getDayOfBirth() {
		return dayOfBirth;
	}
	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	
}
