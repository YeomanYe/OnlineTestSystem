package cn.edu.tjut.test;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.tjut.dao.CommonDao;
import cn.edu.tjut.dao.CommonDaoImp;
import cn.edu.tjut.po.Subject;

public class SpringTest1 {

	private static ApplicationContext context;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Subject subject = (Subject)context.getBean("subject");
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		System.out.println(subject);
		System.out.println(sessionFactory);
	}
	
	@Test
	public void test2(){
		CommonDaoImp cDao = (CommonDaoImp)context.getBean("commonDaoImp");
		cDao.queryPassword("123");
	}

}
