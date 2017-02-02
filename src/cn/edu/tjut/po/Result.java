package cn.edu.tjut.po;

import java.io.Serializable;
import java.util.Date;

public class Result implements Serializable {

	//����
	private int resultID;
	//ѧ��ID
	private String studentID;
	//�Ծ���
	private String paperName;
	//����
	private int score;
	//����
	private Date time;
	//ѧ������
	private Student student;
	
	public Result(){
		
	}
	
	
	
	public Result(String studentID, String paperName, int score, Date time) {
		super();
		this.studentID = studentID;
		this.paperName = paperName;
		this.score = score;
		this.time = time;
	}



	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}



	public int getResultID() {
		return resultID;
	}



	public void setResultID(int resultID) {
		this.resultID = resultID;
	}



	@Override
	public String toString() {
		return "Result [resultID=" + resultID + ", studentID=" + studentID
				+ ", paperName=" + paperName + ", score=" + score + ", time="
				+ time + ", student=" + student + "]";
	}

	
	
}
