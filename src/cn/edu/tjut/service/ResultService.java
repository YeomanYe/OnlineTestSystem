package cn.edu.tjut.service;

import java.util.List;

import cn.edu.tjut.po.Result;

public interface ResultService {

	/**
	 * ͨ��ѧ��ID��ѯ�ɼ�
	 * @param studentID
	 * @return
	 */
	public List<Result> queryResultByStudentID(String studentID);
	/**
	 * ���ѧ���ɼ�
	 * @param result
	 * @return
	 */
	public int addResult(Result result);
	/**
	 * ɾ���ɼ�
	 * @param result
	 * @return
	 */
	public int delResult(Result result);
	/**
	 * ͨ��ID��ѯ�ɼ�
	 * @param resultID
	 * @return
	 */
	public Result queryResultById(String resultID);
	/**
	 * ����Result
	 * @param result
	 * @return
	 */
	public int updateResult(Result result);
}
