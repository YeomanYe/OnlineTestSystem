package cn.edu.tjut.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.SessionFactoryUtils;




public class CommonDaoImp implements CommonDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String queryPassword(String pass) {
		Connection conn = null;
		CallableStatement  statement = null;
		String password = null;
		try {
			conn = SessionFactoryUtils.getDataSource(sessionFactory).getConnection();
			statement = conn.prepareCall("{?=call password(?)}");
			statement.registerOutParameter(1,Types.VARCHAR );
			statement.setString(2, pass);
			statement.execute();
			password = statement.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			releaseResource(conn, statement, null);
		}
		return password;
	}
	/**
	 * 资源释放函数
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public void releaseResource(Connection conn,Statement stmt,ResultSet rs){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn = null;
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				stmt=null;
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
	}

}
