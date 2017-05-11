package info.nguyentai.springmvcdemo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="ID", length=30)
	@NotEmpty
	private String id;
	@Column(name="FULL_NAME", length=50)
	private String fullName;
	@Column(name="DAY_OF_BIRTH")
	@Temporal(TemporalType.DATE)
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
