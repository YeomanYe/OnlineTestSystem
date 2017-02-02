package cn.edu.tjut.po;

import java.util.HashSet;
import java.util.Set;

/**
 * ����ʵ����
 * 
 * @author KINGBOOK
 * 
 */
public class Subject implements java.io.Serializable {

	// ������
	private Integer subjectId;
	// ��������
	private String subjectType;
	// ��������
	private String subjectTitle;
	// Aѡ��
	private String subjectOptionA;
	// Bѡ��
	private String subjectOptionB;
	// Cѡ��
	private String subjectOptionC;
	// Dѡ��
	private String subjectOptionD;
	// ��
	private String subjectAnswer;
	//��ֵ
	private int subjectScore;
	// ����
	private String subjectParse;
	// ����������Ծ�
	private Set<Paper> papers;

	public Subject() {
	}

	public Subject(String subjectTitle, String subjectType,
			String subjectOptionA, String subjectOptionB,
			String subjectOptionC, String subjectOptionD, String subjectAnswer,
			String subjectParse) {
		this.subjectTitle = subjectTitle;
		this.subjectType = subjectType;
		this.subjectOptionA = subjectOptionA;
		this.subjectOptionB = subjectOptionB;
		this.subjectOptionC = subjectOptionC;
		this.subjectOptionD = subjectOptionD;
		this.subjectAnswer = subjectAnswer;
		this.subjectParse = subjectParse;
	}

	public Integer getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectTitle() {
		return this.subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public String getSubjectOptionA() {
		return this.subjectOptionA;
	}

	public void setSubjectOptionA(String subjectOptionA) {
		this.subjectOptionA = subjectOptionA;
	}

	public String getSubjectOptionB() {
		return this.subjectOptionB;
	}

	public void setSubjectOptionB(String subjectOptionB) {
		this.subjectOptionB = subjectOptionB;
	}

	public String getSubjectOptionC() {
		return this.subjectOptionC;
	}

	public void setSubjectOptionC(String subjectOptionC) {
		this.subjectOptionC = subjectOptionC;
	}

	public String getSubjectOptionD() {
		return this.subjectOptionD;
	}

	public void setSubjectOptionD(String subjectOptionD) {
		this.subjectOptionD = subjectOptionD;
	}

	public String getSubjectAnswer() {
		return this.subjectAnswer;
	}

	public void setSubjectAnswer(String subjectAnswer) {
		this.subjectAnswer = subjectAnswer;
	}

	public String getSubjectParse() {
		return this.subjectParse;
	}

	public void setSubjectParse(String subjectParse) {
		this.subjectParse = subjectParse;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectType="
				+ subjectType + ", subjectTitle=" + subjectTitle
				+ ", subjectOptionA=" + subjectOptionA + ", subjectOptionB="
				+ subjectOptionB + ", subjectOptionC=" + subjectOptionC
				+ ", subjectOptionD=" + subjectOptionD + ", subjectAnswer="
				+ subjectAnswer + ", subjectParse=" + subjectParse + "]";
	}

	public Set<Paper> getPapers() {
		return papers;
	}

	public void setPapers(Set<Paper> papers) {
		this.papers = papers;
	}

	public int getSubjectScore() {
		return subjectScore;
	}

	public void setSubjectScore(int subjectScore) {
		this.subjectScore = subjectScore;
	}


	
}