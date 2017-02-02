package cn.edu.tjut.dao;

import java.util.List;

import cn.edu.tjut.model.Page;
import cn.edu.tjut.po.Subject;

/**
 * 试题业务层接口
 * @author KINGBOOK
 *
 */
public interface SubjectDao {
	/**
	 * 查询全部试题
	 * @param subjectType TODO
	 * @param subjectTitle TODO
	 * @param page TODO
	 * @return
	 */
	public List<Subject> querySubject(String subjectType, String subjectTitle, Page page);
	/**
	 * 添加试题
	 * @param subject
	 */
	public void addSubject(Subject subject);
	/**
	 * 删除一个试题
	 * @param subject
	 */
	public void delOneSubject(Subject subject);
	/**
	 * 批量删除
	 * @param subjectIds TODO
	 */
	public void delBatchSubject(String[] subjectIds);
	/**
	 * 更新试题
	 * @param subject
	 */
	public void updateSubject(Subject subject);
	/**
	 * 通过id查询subject
	 * @param subjectId
	 * @return TODO
	 */
	public Subject querySubjectById(String subjectId);
}
