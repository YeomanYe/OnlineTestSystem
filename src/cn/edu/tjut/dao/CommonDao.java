package cn.edu.tjut.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface CommonDao {
	/**
	 * �������
	 * @param pass
	 * @return
	 */
	public String queryPassword(String pass);
	/**
	 * ��Դ�ͷź���
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public void releaseResource(Connection conn,Statement stmt,ResultSet rs);
}
