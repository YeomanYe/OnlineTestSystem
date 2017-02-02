package cn.edu.tjut.dao;

import java.util.List;

import cn.edu.tjut.po.Result;

public interface ResultDao {
	
	/**
	 * ͬ��ѧ��ID��ѯ�ɼ�
	 * @param studentID
	 * @return
	 */
	public List<Result> queryResultByStudentID(String studentID);
	/**
	 * ��ӳɼ�
	 * @param result
	 */
	public void addResult(Result result);
	/**
	 * ɾ���ɼ�
	 * @param result
	 */
	public void delResult(Result result);
	/**
	 * ͨ��ID��ѯ�ɼ�
	 * @param resultID
	 * @return
	 */
	public Result queryResultById(String resultID);
	/**
	 * ���³ɼ�
	 * @param result
	 */
	public void updateResult(Result result);
}
