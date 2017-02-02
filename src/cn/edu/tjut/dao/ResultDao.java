package cn.edu.tjut.dao;

import java.util.List;

import cn.edu.tjut.po.Result;

public interface ResultDao {
	
	/**
	 * 同过学生ID查询成绩
	 * @param studentID
	 * @return
	 */
	public List<Result> queryResultByStudentID(String studentID);
	/**
	 * 添加成绩
	 * @param result
	 */
	public void addResult(Result result);
	/**
	 * 删除成绩
	 * @param result
	 */
	public void delResult(Result result);
	/**
	 * 通过ID查询成绩
	 * @param resultID
	 * @return
	 */
	public Result queryResultById(String resultID);
	/**
	 * 更新成绩
	 * @param result
	 */
	public void updateResult(Result result);
}
