package cn.edu.tjut.service;

import cn.edu.tjut.po.Teacher;

public interface TeacherService {

	/**
	 * ͨ��id��ѯTeacher
	 * @param teacherId
	 * @return
	 */
	public Teacher queryTeacherById(String teacherId);
	/**
	 * ��ѯ����
	 */
	public String queryPassword(String pass);
}
