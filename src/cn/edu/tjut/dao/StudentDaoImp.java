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
	 * 根据班级查询学生
	 */
	@Override
	public List<Student> queryStudentByClass(String sclass) {
		String hql = " from Student where sclass='"+sclass+"'"; 
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	/**
	 * 根据ID查询学生
	 */
	@Override
	public Student queryStudentById(String studentId) {
		return (Student)sessionFactory.getCurrentSession().get(Student.class, studentId);
	}
	/**
	 * 更新学生
	 * @param student
	 */
	public void updateStudent(Student student){
		sessionFactory.getCurrentSession().update(student);
	}
	/**
	 * 添加学生
	 * @param student
	 */
	public void addStudent(Student student){
		sessionFactory.getCurrentSession().save(student);
	}
}
