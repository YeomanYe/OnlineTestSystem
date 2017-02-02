package cn.edu.tjut.service;

import java.util.List;

import cn.edu.tjut.model.Page;
import cn.edu.tjut.po.Paper;

public interface PaperService {

	/**
	 * 添加试卷
	 * @param paper
	 */
	public int addPaper(Paper paper);
	
	/**
	 * 通过id查询paper
	 * @param paper
	 * @return
	 */
	public Paper queryPaperById(String paperId);
	/**
	 * 查询全部paper
	 * @param paperName TODO
	 * @param paperDescription TODO
	 * @param page TODO
	 * @return
	 */
	public List<Paper> queryPaper(String paperName, String paperDescription, Page page);
	/**
	 * 更新paper
	 * @param paper
	 * @return
	 */
	public int updatePaper(Paper paper);
	/**
	 * 删除一个Paper
	 * @param paperId
	 * @return
	 */
	public int delOnePaper(String paperId);
	/**
	 * 查询试卷为了考试
	 * @return
	 */
	public List<Paper> queryAllPaper();
	/**
	 * 查询试卷数量
	 * @return
	 */
	public int queryCountPaper();
	/**
	 * 批量删除试卷
	 * @param paperIds
	 * @return
	 */
	public int delBatchPaper(String[] paperIds);
}
