package cn.edu.tjut.service;

import java.util.List;

import cn.edu.tjut.model.Page;
import cn.edu.tjut.po.Subject;

/**
 * 试题服务接口
 * @author KINGBOOK
 *
 */
public interface SubjectService {
	/**
	 * 查询全部的试题
	 * @param subjectType TODO
	 * @param subjectTitle TODO
	 * @param page TODO
	 * @return
	 */
	public List<Subject> querySubject(String subjectType, String subjectTitle, Page page);
	/**
	 * 添加试题
	 * @param Subject TODO
	 * @return
	 */
	public int addSubject(Subject subject);
	/**
	 * 删除一个试题
	 * @param Subject TODO
	 * @return
	 */
	public int delOneSubject(String subjectId);
	/**
	 * 批量删除
	 * @param subjectIds TODO
	 * @return
	 */
	public int delBatchSubject(String[] subjectIds);
	/**
	 * 更新试题
	 * @param subject
	 * @return
	 */
	public int updateSubject(Subject subject);
	/**
	 * 根据ID查询试题
	 * @param subjectId
	 * @return
	 */
	public Subject querySubjectById(String subjectId);
}
