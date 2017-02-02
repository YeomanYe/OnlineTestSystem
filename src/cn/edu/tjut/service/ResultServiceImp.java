package cn.edu.tjut.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.edu.tjut.dao.ResultDao;
import cn.edu.tjut.po.Result;

public class ResultServiceImp implements ResultService {

	private ResultDao resultDao;
	
	
	
	public void setResultDao(ResultDao resultDao) {
		this.resultDao = resultDao;
	}



	/**
	 * ͨ��ѧ��ID��ѯ�ɼ�
	 * @param studentID
	 * @return
	 */
	@Override
	public List<Result> queryResultByStudentID(String studentID) {
		return resultDao.queryResultByStudentID(studentID);
	}

	/**
	 * ��ӳɼ�
	 * @param result
	 */
	public int addResult(Result result){
		resultDao.addResult(result);
		return 0;
	}
	/**
	 * ɾ���ɼ�
	 * @param result
	 * @return
	 */
	public int delResult(Result result){
		resultDao.delResult(result);
		return 0;
	}
	
	/**
	 * ͨ��ID��ѯ�ɼ�
	 * @param resultID
	 * @return
	 */
	public Result queryResultById(String resultID){
		return resultDao.queryResultById(resultID);
	}
	/**
	 * ���³ɼ�
	 * @param result
	 * @return
	 */
	public int updateResult(Result result){
		resultDao.updateResult(result);
		return 0;
	}
}
