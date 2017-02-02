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
	 * 通过学生id查询成绩
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
	 * 添加成绩
	 * @param result
	 */
	@Override
	public void addResult(Result result) {
		sessionFactory.getCurrentSession().save(result);
	}
	/**
	 * 删除成绩
	 * @param result
	 */
	public void delResult(Result result){
		sessionFactory.getCurrentSession().delete(result);
	}
	/**
	 * 通过ID查询成绩
	 */
	public Result queryResultById(String resultID){
		String hql = "from Result where resultID ="+resultID;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (Result)query.uniqueResult();
	}
	/**
	 * 更新成绩
	 * @param result
	 */
	public void updateResult(Result result){
		sessionFactory.getCurrentSession().update(result);
	}
}
