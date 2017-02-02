package cn.edu.tjut.dao;

import java.util.List;

import cn.edu.tjut.po.Student;

public interface StudentDao {

	/**
	 * 通过班级查询学生
	 * @param sclass
	 * @return
	 */
	public List<Student> queryStudentByClass(String sclass);
	/**
	 * 通过ID查询学生
	 * @param studentId
	 * @return
	 */
	public Student queryStudentById(String studentId);
	/**
	 * 更新学生
	 * @param student
	 */
	public void updateStudent(Student student);
	/**
	 * 添加学生
	 * @param student
	 */
	public void addStudent(Student student);
}
