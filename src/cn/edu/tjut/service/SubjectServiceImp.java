package cn.edu.tjut.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.edu.tjut.dao.PageDao;
import cn.edu.tjut.dao.SubjectDao;
import cn.edu.tjut.model.Page;
import cn.edu.tjut.po.Paper;
import cn.edu.tjut.po.Subject;

public class SubjectServiceImp implements SubjectService {

	private SubjectDao subjectDao;
	
	private PageDao pageDao;
	
	

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}
	
	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}

	
	@Override
	public List<Subject> querySubject(String subjectType, String subjectTitle, Page page) {
		int totalNumber = pageDao.queryTotalPage(subjectType, subjectTitle, "Subject");
		page.setTotalNumber(totalNumber);
		return subjectDao.querySubject(subjectType, subjectTitle, page);
	}

	@Override
	public int addSubject(Subject subject) {
		subjectDao.addSubject(subject);
		return 0;
	}

	@Override
	public int delOneSubject(String subjectId) {
		//查询subject,判断是否有试卷包含试题,若无试卷包含才可删除;
		int retNum = -1;
		Subject subject = subjectDao.querySubjectById(subjectId);
		Set<Paper> papers = subject.getPapers();
		if(papers.isEmpty() || papers==null){
			subjectDao.delOneSubject(subject);
			retNum = 0;
		}
		return retNum;
	}

	@Override
	public int delBatchSubject(String[] subjectIds) {
		subjectDao.delBatchSubject(subjectIds);
		return 0;
	}

	@Override
	public int updateSubject(Subject subject) {
		subjectDao.updateSubject(subject);
		return 0;
	}

	@Override
	public Subject querySubjectById(String subjectId) {
		return subjectDao.querySubjectById(subjectId);
	}
	

}
