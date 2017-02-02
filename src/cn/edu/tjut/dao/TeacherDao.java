package cn.edu.tjut.dao;

import cn.edu.tjut.po.Teacher;

public interface TeacherDao {

	/**
	 * Í¨¹ýid²éÑ¯Teacher
	 * @param teacherId
	 * @return
	 */
	public Teacher queryTeacherById(String teacherId);
}
