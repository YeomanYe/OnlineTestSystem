package cn.edu.tjut.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.tjut.dao.CommonDaoImp;
import cn.edu.tjut.po.Paper;
import cn.edu.tjut.po.Result;
import cn.edu.tjut.po.Student;
import cn.edu.tjut.po.Subject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {

	
	@Resource
	private SessionFactory sessionFactory;
	


	@Test
	public void springTest(){
		
		String hql = " from Student ";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<Student> students = query.list();
		for(Student s:students){
			System.out.println(s.toString());
		}
	}
	
	@Test
	public void springTest2(){
		
		String hql = "select count(*) from Student ";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		System.out.println("count:"+((Long)query.uniqueResult()).intValue());
	}
	

	@Test
	public void springTest3(){
		
		String hql = " from Subject ";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		List<Subject> subjects = query.list();
		for(Subject s:subjects){
			System.out.println(s);
		}
	}

	@Test
	public void many2many(){
		Paper paper = new Paper("вш╨о",100,"Mr.A");
		
		
		
		Subject subject = new Subject("a","a","a","a","a","a","a","a");
		
		paper.getSubjects().add(subject);
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(paper);
		paper.setPaperScore(20);
		int i=60000;
		while(i==0){
			i--;
			for(int j=0;j<i;j++);
		}
		tx.commit();
	}
	
	@Test
	public void testStudentTB(){
		String hql = " from Student ";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		List<Student> students = query.list();
		for(Student s:students){
			System.out.println(s);
		}
	}
	@Test
	public void testLazyMode(){
	  Paper paper =(Paper) sessionFactory.openSession().get(Paper.class, 49);
	  
	  System.out.println(paper.getPaperName());
	  
	  System.out.println(paper.getSubjects().size());
	}
	@Test
	public void manytoOne(){
		String hql = "from Result";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		List<Result> results = query.list();
		results.get(5).setScore(100);
		for(Result s:results){
			System.out.println(s);
		}
		int i=60000;
		while(i==0){
			i--;
			for(int j=0;j<i;j++);
		}
	}
	
	@Resource
	private CommonDaoImp commonDaoImp;
	@Test
	public void testGetPassword(){
		String password=commonDaoImp.queryPassword("123");
		System.out.println(password);
	}
}
