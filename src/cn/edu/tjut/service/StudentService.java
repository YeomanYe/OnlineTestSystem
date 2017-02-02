package cn.edu.tjut.service;

import java.util.List;

import cn.edu.tjut.po.Student;

public interface StudentService {
	/**
	 * ͨ���༶��ѯѧ��
	 * @param sclass
	 * @return
	 */
	public List<Student> queryStudentByClass(String sclass);
	
	/**
	 * ����ID��ѯѧ��
	 * @param studentId
	 * @return
	 */
	public Student queryStudentById(String studentId);
	/**
	 * ����ѧ��
	 * @param student
	 * @return
	 */
	public int updateStudent(Student student);
	/**
	 * ���ѧ��
	 * @param sclass TODO
	 * @param student
	 */
	public int addStudent(String studentID,String password, String sclass);
	/**
	 * �����ѯ
	 * @param pass
	 * @return
	 */
	public String queryPassword(String pass);
}
