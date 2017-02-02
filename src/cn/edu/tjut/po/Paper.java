package cn.edu.tjut.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Paper {

	// �Ծ���
	private int paperId;
	// �Ծ�����
	private String paperName;
	// �Ծ��ܷ�
	private int paperScore;
	//�Ծ�����
	private int paperSubjectNumber;
	// ��д��
	private String paperAuthor;
	// ��������
	private Date paperCreateDate;
	// ��������
	private Date paperUpdateDate;
	//�Ծ�����
	private String paperDescription;
	//�������⼯��
	private Set<Subject> subjects = new HashSet<Subject>() ;

	public Paper(String paperName, int paperScore,
			String paperAuthor) {
		super();
		this.paperName = paperName;
		this.paperScore = paperScore;
		this.paperAuthor = paperAuthor;
	}

	public Paper() {
		super();
	}

	public int getPaperId() {
		return paperId;
	}

	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public int getPaperScore() {
		return paperScore;
	}

	public void setPaperScore(int paperScore) {
		this.paperScore = paperScore;
	}

	public String getPaperAuthor() {
		return paperAuthor;
	}

	public void setPaperAuthor(String paperAuthor) {
		this.paperAuthor = paperAuthor;
	}

	public Date getPaperCreateDate() {
		return paperCreateDate;
	}

	public void setPaperCreateDate(Date paperCreateDate) {
		this.paperCreateDate = paperCreateDate;
	}

	public Date getPaperUpdateDate() {
		return paperUpdateDate;
	}

	public void setPaperUpdateDate(Date paperUpdateDate) {
		this.paperUpdateDate = paperUpdateDate;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public String getPaperDescription() {
		return paperDescription;
	}

	public void setPaperDescription(String paperDescription) {
		this.paperDescription = paperDescription;
	}

	public int getPaperSubjectNumber() {
		return paperSubjectNumber;
	}

	public void setPaperSubjectNumber(int paperSubjectNumber) {
		this.paperSubjectNumber = paperSubjectNumber;
	}

	
}
