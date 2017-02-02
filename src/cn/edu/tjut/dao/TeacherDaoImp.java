package cn.edu.tjut.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.tjut.po.Teacher;

public class TeacherDaoImp implements TeacherDao {

	private SessionFactory sessionFactory;

	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	/**
	 * Í¨¹ýid²éÑ¯Teacher
	 * @param teacherId
	 * @return
	 */
	@Override
	public Teacher queryTeacherById(String teacherId) {
		String hql = "from Teacher where teacherID='"+teacherId+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (Teacher)query.uniqueResult();
	}

}
