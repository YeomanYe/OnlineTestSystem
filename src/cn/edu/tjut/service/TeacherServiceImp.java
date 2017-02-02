package cn.edu.tjut.service;

import cn.edu.tjut.dao.CommonDao;
import cn.edu.tjut.dao.TeacherDao;
import cn.edu.tjut.po.Teacher;

public class TeacherServiceImp implements TeacherService {

	private CommonDao commonDao;
	
	private TeacherDao teacherDao;
	
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	/**
	 * ͨ��id��ѯTeacher
	 * @param teacherId
	 * @return
	 */
	@Override
	public Teacher queryTeacherById(String teacherId) {
		return teacherDao.queryTeacherById(teacherId);
	}
	/**
	 * �����ѯ
	 * @param pass
	 * @return
	 */
	public String queryPassword(String pass){
		return commonDao.queryPassword(pass);
	}

}
