package cn.edu.tjut.service;

import java.util.List;

import cn.edu.tjut.model.Page;
import cn.edu.tjut.po.Subject;

/**
 * �������ӿ�
 * @author KINGBOOK
 *
 */
public interface SubjectService {
	/**
	 * ��ѯȫ��������
	 * @param subjectType TODO
	 * @param subjectTitle TODO
	 * @param page TODO
	 * @return
	 */
	public List<Subject> querySubject(String subjectType, String subjectTitle, Page page);
	/**
	 * �������
	 * @param Subject TODO
	 * @return
	 */
	public int addSubject(Subject subject);
	/**
	 * ɾ��һ������
	 * @param Subject TODO
	 * @return
	 */
	public int delOneSubject(String subjectId);
	/**
	 * ����ɾ��
	 * @param subjectIds TODO
	 * @return
	 */
	public int delBatchSubject(String[] subjectIds);
	/**
	 * ��������
	 * @param subject
	 * @return
	 */
	public int updateSubject(Subject subject);
	/**
	 * ����ID��ѯ����
	 * @param subjectId
	 * @return
	 */
	public Subject querySubjectById(String subjectId);
}
