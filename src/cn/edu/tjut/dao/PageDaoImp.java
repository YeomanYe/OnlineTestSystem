package cn.edu.tjut.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PageDaoImp implements PageDao {

	private SessionFactory sessionFactory;
	
	@Override
	public int queryTotalPage(String type, String description, String table) {
		String hql = " select count(*) ";
		if(table.equals("Subject")){
			hql+=" from Subject where 1=1 ";
			if(type!=null && !"".equals(type.trim())){
				hql+=" and subjectType ='"+type+"'";
			}
			if(description!=null && !"".equals(description.trim())){
				hql+=" and subjectTitle like '%"+description+"%'";
			}
		}
		else if(table.equals("Paper")){
			hql+=" from Paper where 1=1 ";
			if(type!=null && !"".equals(type.trim())){
				hql+=" and paperName like '%"+type+"%'";
			}
			if(description!=null && !"".equals(description.trim())){
				hql+=" and paperDescription like '%"+description+"%'";
			}
		}
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return ((Long)query.uniqueResult()).intValue();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
