package info.nguyentai.springmvcdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.nguyentai.springmvcdemo.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Student> getAllStudents() {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		List<Student> students = new ArrayList<Student>();

		transaction.begin();
		students = session.createCriteria(Student.class).list();
		transaction.commit();

		return students;
	}

	@Override
	public void addStudent(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.persist(student);
		transaction.commit();
	}

}
