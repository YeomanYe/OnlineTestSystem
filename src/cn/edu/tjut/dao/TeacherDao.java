package cn.edu.tjut.dao;

import cn.edu.tjut.po.Teacher;

public interface TeacherDao {

	/**
	 * ͨ��id��ѯTeacher
	 * @param teacherId
	 * @return
	 */
	public Teacher queryTeacherById(String teacherId);
}
