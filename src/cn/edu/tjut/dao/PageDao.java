package cn.edu.tjut.dao;

public interface PageDao {
	/**
	 * ��ѯ��ҳ��
	 * @param table TODO
	 * @param subjectType����
	 * @param subjectTitle����
	 * @return
	 */
	public int queryTotalPage(String type,String description, String table);
	
}
