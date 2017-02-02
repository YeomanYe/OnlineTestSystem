package cn.edu.tjut.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.tjut.model.Page;
import cn.edu.tjut.po.Paper;

public class PaperDaoImp implements PaperDao {

	private SessionFactory sessionFactory;
	
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/**
	 * 添加试卷
	 * @param paper
	 */
	@Override
	public void addPaper(Paper paper) {
		sessionFactory.getCurrentSession().merge(paper);
	}


	/**
	 * 通过id查询试卷
	 * @param paperId
	 * @return 
	 */
	@Override
	public Paper queryPaperById(String paperId) {
		Paper paper = (Paper)sessionFactory.getCurrentSession().get(Paper.class, Integer.parseInt(paperId));
		return paper;
	}



	@Override
	public List<Paper> queryPaper(String paperName, String paperDescription, Page page) {
		String hql = "from Paper where 1=1 ";
		if(paperName!=null && !"".equals(paperName.trim())){
			hql += " and paperName like '%"+paperName+"%'";
		}
		if(paperDescription!=null && !"".equals(paperDescription.trim())){
			hql +=" and paperDescription like '%"+paperDescription+"%'";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(page.getShowIndex());
		query.setMaxResults(page.getShowNumber());
		return query.list();
	}
	/**
	 * 更新paper
	 */
	public void updatePaper(Paper paper){
		sessionFactory.getCurrentSession().merge(paper);
	}
	/**
	 * 删除一份Paper
	 */
	@Override
	public void delOnePaper(Paper paper) {
		sessionFactory.getCurrentSession().delete(paper);
	}



	@Override
	public List<Paper> queryAllPaper() {
		String hql = "from Paper";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}



	@Override
	public int queryCountPaper() {
		String hql = "select count(*) from Paper";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return ((Long)query.uniqueResult()).intValue();
	}
	
	/**
	 * 批量删除
	 */
	@Override
	public void delBatchPaper(String[] paperIds) {
		String hql = "delete Paper where ";
		if(paperIds.length>=1){
			hql += " paperId="+paperIds[0];
		}
		for(int i=1;i<paperIds.length;i++){
			hql += " or paperId="+paperIds[i];
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
	}
}
