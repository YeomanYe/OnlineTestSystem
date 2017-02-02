package cn.edu.tjut.po;

import java.util.Date;
import java.util.Set;

public class Student {

	// 学生ID
	private String studentID;
	// 密码
	private String password;
	// 学生姓名
	private String studentName;
	// 得分
	private int result;
	// 所在班级
	private String sclass;
	// 学生性别
	private boolean studentSex;
	// 学生年龄
	private int studentAge;
	// 学生邮箱
	private String studentEmail;
	// 注册时间
	private Date studentRegisterDate;
	// 成绩表的集合
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
