package cn.edu.tjut.po;

import java.util.Date;
import java.util.Set;

public class Student {

	// ѧ��ID
	private String studentID;
	// ����
	private String password;
	// ѧ������
	private String studentName;
	// �÷�
	private int result;
	// ���ڰ༶
	private String sclass;
	// ѧ���Ա�
	private boolean studentSex;
	// ѧ������
	private int studentAge;
	// ѧ������
	private String studentEmail;
	// ע��ʱ��
	private Date studentRegisterDate;
	// �ɼ���ļ���
	private Set<Result> results;

	public Student() {

	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public boolean isStudentSex() {
		return studentSex;
	}

	public void setStudentSex(boolean studentSex) {
		this.studentSex = studentSex;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public Date getStudentRegisterDate() {
		return studentRegisterDate;
	}

	public void setStudentRegisterDate(Date studentRegisterDate) {
		this.studentRegisterDate = studentRegisterDate;
	}

	public Set<Result> getResults() {
		return results;
	}

	public void setResults(Set<Result> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", password=" + password
				+ ", studentName=" + studentName + ", result=" + result
				+ ", sclass=" + sclass + ", studentSex=" + studentSex
				+ ", studentAge=" + studentAge + ", studentEmail="
				+ studentEmail + ", studentRegisterDate=" + studentRegisterDate
				+ "]";
	}

}
