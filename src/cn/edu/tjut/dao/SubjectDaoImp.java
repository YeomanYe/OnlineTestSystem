package cn.edu.tjut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.tjut.model.Page;
import cn.edu.tjut.po.Subject;

public class SubjectDaoImp implements SubjectDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 查询试题，为了显示
	 */
	@Override
	public List<Subject> querySubject(String subjectType, String subjectTitle, Page page) {
		String hql = "from Subject where 1=1 ";
		if(subjectType!=null && !"".equals(subjectType.trim())){
			hql+=" and subjectType = '"+subjectType+"'";
		}
		if(subjectTitle!=null && !"".equals(subjectTitle.trim())){
			hql+=" and subjectTitle like '%"+subjectTitle+"%'";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(page.getShowIndex());
		query.setMaxResults(page.getShowNumber());
		List<Subject> subjects = query.list();
		return subjects;
	}

	/**
	 * 添加试题
	 * @param subject
	 */
	@Override
	public void addSubject(Subject subject) {
		sessionFactory.getCurrentSession().save(subject);
	}
	/**
	 * 删除一个试题
	 * @param subject
	 */
	@Override
	public void delOneSubject(Subject subject) {
		sessionFactory.getCurrentSession().delete(subject);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delBatchSubject(String[] subjectIds) {
		String hql = "delete Subject where ";
		if(subjectIds.length>=1){
			hql += " subjectId="+subjectIds[0];
		}
		for(int i=1;i<subjectIds.length;i++){
			hql += " or subjectId="+subjectIds[i];
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
	}

	@Override
	public void updateSubject(Subject subject) {
		sessionFactory.getCurrentSession().update(subject);
	}

	@Override
	public Subject querySubjectById(String subjectId) {
		String hql = "from Subject where subjectId="+subjectId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (Subject)query.list().get(0);
	}

}
