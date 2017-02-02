package cn.edu.tjut.dao;

import java.util.List;

import cn.edu.tjut.po.Student;

public interface StudentDao {

	/**
	 * ͨ���༶��ѯѧ��
	 * @param sclass
	 * @return
	 */
	public List<Student> queryStudentByClass(String sclass);
	/**
	 * ͨ��ID��ѯѧ��
	 * @param studentId
	 * @return
	 */
	public Student queryStudentById(String studentId);
	/**
	 * ����ѧ��
	 * @param student
	 */
	public void updateStudent(Student student);
	/**
	 * ���ѧ��
	 * @param student
	 */
	public void addStudent(Student student);
}
