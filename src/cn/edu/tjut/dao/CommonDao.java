package cn.edu.tjut.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface CommonDao {
	/**
	 * 获得密码
	 * @param pass
	 * @return
	 */
	public String queryPassword(String pass);
	/**
	 * 资源释放函数
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public void releaseResource(Connection conn,Statement stmt,ResultSet rs);
}
