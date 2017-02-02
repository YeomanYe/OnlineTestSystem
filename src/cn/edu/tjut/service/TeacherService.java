package cn.edu.tjut.service;

import cn.edu.tjut.po.Teacher;

public interface TeacherService {

	/**
	 * 通过id查询Teacher
	 * @param teacherId
	 * @return
	 */
	public Teacher queryTeacherById(String teacherId);
	/**
	 * 查询密码
	 */
	public String queryPassword(String pass);
}
