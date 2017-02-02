package cn.edu.tjut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.tjut.po.Result;

public class ResultDaoImp implements ResultDao {

	private SessionFactory sessionFactory;
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/**
	 * ͨ��ѧ��id��ѯ�ɼ�
	 * @param studentID
	 * @return
	 */
	@Override
	public List<Result> queryResultByStudentID(String studentID) {
		String hql = " from Result where studentID='"+studentID+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}


	/**
	 * ��ӳɼ�
	 * @param result
	 */
	@Override
	public void addResult(Result result) {
		sessionFactory.getCurrentSession().save(result);
	}
	/**
	 * ɾ���ɼ�
	 * @param result
	 */
	public void delResult(Result result){
		sessionFactory.getCurrentSession().delete(result);
	}
	/**
	 * ͨ��ID��ѯ�ɼ�
	 */
	public Result queryResultById(String resultID){
		String hql = "from Result where resultID ="+resultID;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (Result)query.uniqueResult();
	}
	/**
	 * ���³ɼ�
	 * @param result
	 */
	public void updateResult(Result result){
		sessionFactory.getCurrentSession().update(result);
	}
}
