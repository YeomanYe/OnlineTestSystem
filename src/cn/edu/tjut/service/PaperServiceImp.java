package cn.edu.tjut.service;

import java.util.List;

import cn.edu.tjut.dao.PageDao;
import cn.edu.tjut.dao.PaperDao;
import cn.edu.tjut.model.Page;
import cn.edu.tjut.po.Paper;

public class PaperServiceImp implements PaperService {

	private PageDao pageDao;
	
	private PaperDao paperDao;

	public void setPaperDao(PaperDao paperDao) {
		this.paperDao = paperDao;
	}


	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}


	/**
	 * 添加试卷
	 * @param paper
	 */
	@Override
	public int addPaper(Paper paper) {
		paperDao.addPaper(paper);
		return 0;
	}

	/**
	 * 通过id查询试卷
	 * @param paperId
	 * @return 
	 */
	@Override
	public Paper queryPaperById(String paperId) {
		return paperDao.queryPaperById(paperId);
	}

	/**
	 * 查询全部paper,为了显示
	 */
	@Override
	public List<Paper> queryPaper(String paperName, String paperDescription, Page page) {
		int totalNumber = pageDao.queryTotalPage(paperName, paperDescription, "Paper");
		page.setTotalNumber(totalNumber);
		return paperDao.queryPaper(paperName, paperDescription, page);
	}
	/**
	 * 更新paper
	 * return 
	 */
	public int updatePaper(Paper paper){
		paperDao.updatePaper(paper);
		return 0;
	}
	/**
	 * 删除一份paper
	 */
	@Override
	public int delOnePaper(String paperId) {
		if(paperId!=null && !"".equals(paperId.trim())){
			Paper paper = paperDao.queryPaperById(paperId);
			paperDao.delOnePaper(paper);
		}
		return 0;
	}
	/**
	 * 查询全部paper
	 */
	@Override
	public List<Paper> queryAllPaper() {
		return paperDao.queryAllPaper();
	}
	/**
	 * 查询paper总数
	 */
	@Override
	public int queryCountPaper() {
		return paperDao.queryCountPaper();
	}
	/**
	 * 批量删除paper
	 */
	public int delBatchPaper(String[] paperIds){
		paperDao.delBatchPaper(paperIds);
		return 0;
	}
}
