package cn.edu.tjut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.tjut.po.Student;

public class StudentDaoImp implements StudentDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * ���ݰ༶��ѯѧ��
	 */
	@Override
	public List<Student> queryStudentByClass(String sclass) {
		String hql = " from Student where sclass='"+sclass+"'"; 
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	/**
	 * ����ID��ѯѧ��
	 */
	@Override
	public Student queryStudentById(String studentId) {
		return (Student)sessionFactory.getCurrentSession().get(Student.class, studentId);
	}
	/**
	 * ����ѧ��
	 * @param student
	 */
	public void updateStudent(Student student){
		sessionFactory.getCurrentSession().update(student);
	}
	/**
	 * ���ѧ��
	 * @param student
	 */
	public void addStudent(Student student){
		sessionFactory.getCurrentSession().save(student);
	}
}
