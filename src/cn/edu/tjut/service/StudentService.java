package cn.edu.tjut.service;

import java.util.List;

import cn.edu.tjut.po.Student;

public interface StudentService {
	/**
	 * 通过班级查询学生
	 * @param sclass
	 * @return
	 */
	public List<Student> queryStudentByClass(String sclass);
	
	/**
	 * 根据ID查询学生
	 * @param studentId
	 * @return
	 */
	public Student queryStudentById(String studentId);
	/**
	 * 更新学生
	 * @param student
	 * @return
	 */
	public int updateStudent(Student student);
	/**
	 * 添加学生
	 * @param sclass TODO
	 * @param student
	 */
	public int addStudent(String studentID,String password, String sclass);
	/**
	 * 密码查询
	 * @param pass
	 * @return
	 */
	public String queryPassword(String pass);
}
