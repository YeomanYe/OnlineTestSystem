package cn.edu.tjut.dao;

import java.util.List;

import cn.edu.tjut.model.Page;
import cn.edu.tjut.po.Paper;

public interface PaperDao {

	/**
	 * 添加试卷
	 * @param paper
	 */
	public void addPaper(Paper paper);
	
	/**
	 * 通过id查询试卷
	 * @param paperId
	 * @return 
	 */
	public Paper queryPaperById(String paperId);
	/**
	 * 查询paper
	 * @param paperName TODO
	 * @param paperDescription TODO
	 * @param page TODO
	 * @return
	 */
	public List<Paper> queryPaper(String paperName, String paperDescription, Page page);
	/**
	 * 更新Paper
	 * @param paper
	 */
	public void updatePaper(Paper paper);
	/**
	 * 删除一份试卷
	 * @param paper
	 */
	public void delOnePaper(Paper paper);
	/**
	 * 查询全部卷子
	 * @return
	 */
	public List<Paper> queryAllPaper();
	/**
	 * 查询Paper数量
	 * @return
	 */
	public int queryCountPaper();
	/**
	 * 批量删除
	 * @param paperIds
	 */
	public void delBatchPaper(String[] paperIds);
}
