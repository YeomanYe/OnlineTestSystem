package cn.edu.tjut.dao;

import java.util.List;

import cn.edu.tjut.model.Page;
import cn.edu.tjut.po.Subject;

/**
 * ����ҵ���ӿ�
 * @author KINGBOOK
 *
 */
public interface SubjectDao {
	/**
	 * ��ѯȫ������
	 * @param subjectType TODO
	 * @param subjectTitle TODO
	 * @param page TODO
	 * @return
	 */
	public List<Subject> querySubject(String subjectType, String subjectTitle, Page page);
	/**
	 * �������
	 * @param subject
	 */
	public void addSubject(Subject subject);
	/**
	 * ɾ��һ������
	 * @param subject
	 */
	public void delOneSubject(Subject subject);
	/**
	 * ����ɾ��
	 * @param subjectIds TODO
	 */
	public void delBatchSubject(String[] subjectIds);
	/**
	 * ��������
	 * @param subject
	 */
	public void updateSubject(Subject subject);
	/**
	 * ͨ��id��ѯsubject
	 * @param subjectId
	 * @return TODO
	 */
	public Subject querySubjectById(String subjectId);
}
