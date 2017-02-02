package cn.edu.tjut.dao;

public interface PageDao {
	/**
	 * 查询总页数
	 * @param table TODO
	 * @param subjectType类型
	 * @param subjectTitle描述
	 * @return
	 */
	public int queryTotalPage(String type,String description, String table);
	
}
