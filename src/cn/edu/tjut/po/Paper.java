package cn.edu.tjut.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Paper {

	// 试卷编号
	private int paperId;
	// 试卷名称
	private String paperName;
	// 试卷总分
	private int paperScore;
	//试卷题量
	private int paperSubjectNumber;
	// 编写人
	private String paperAuthor;
	// 创建日期
	private Date paperCreateDate;
	// 更新日期
	private Date paperUpdateDate;
	//试卷描述
	private String paperDescription;
	//保存试题集合
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
