package cn.edu.tjut.service;

import java.util.List;

import cn.edu.tjut.dao.CommonDao;
import cn.edu.tjut.dao.StudentDao;
import cn.edu.tjut.po.Student;
import cn.edu.tjut.util.Const;

public class StudentServiceImp implements StudentService {

	private CommonDao commonDao;
	
	private StudentDao studentDao;

	private Student student;

	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> queryStudentByClass(String sclass) {
		return studentDao.queryStudentByClass(sclass);
	}

	@Override
	public Student queryStudentById(String studentId) {
		return studentDao.queryStudentById(studentId);
	}

	/**
	 * 更新学生
	 * 
	 * @param student
	 * @return
	 */
	public int updateStudent(Student student) {
		int ret = -1;
		studentDao.updateStudent(student);
		ret = 0;
		return ret;
	}

	/**
	 * 添加学生
	 * @param student
	 */
	public int addStudent(String studentID, String password, String sclass) {
		int retNum = 1;
		student.setStudentID(studentID);
		student.setPassword(password);
		if(sclass.equals(Const.CLASS1_NAME)){
			student.setSclass(Const.CLASS1_NUMBER);
		}
		else if(sclass.equals(Const.CLASS2_NAME)){
			student.setSclass(Const.CLASS2_NUMBER);
		}
		studentDao.addStudent(student);
		retNum = 0;
		return retNum;
	}
	/**
	 * 密码查询
	 * @param pass
	 * @return
	 */
	public String queryPassword(String pass){
		return 	commonDao.queryPassword(pass);
	}
}
