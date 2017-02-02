package cn.edu.tjut.service;

import java.util.List;

import cn.edu.tjut.po.Result;

public interface ResultService {

	/**
	 * 通过学生ID查询成绩
	 * @param studentID
	 * @return
	 */
	public List<Result> queryResultByStudentID(String studentID);
	/**
	 * 添加学生成绩
	 * @param result
	 * @return
	 */
	public int addResult(Result result);
	/**
	 * 删除成绩
	 * @param result
	 * @return
	 */
	public int delResult(Result result);
	/**
	 * 通过ID查询成绩
	 * @param resultID
	 * @return
	 */
	public Result queryResultById(String resultID);
	/**
	 * 更新Result
	 * @param result
	 * @return
	 */
	public int updateResult(Result result);
}
