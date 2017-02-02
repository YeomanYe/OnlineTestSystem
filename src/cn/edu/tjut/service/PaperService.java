package cn.edu.tjut.service;

import java.util.List;

import cn.edu.tjut.model.Page;
import cn.edu.tjut.po.Paper;

public interface PaperService {

	/**
	 * ����Ծ�
	 * @param paper
	 */
	public int addPaper(Paper paper);
	
	/**
	 * ͨ��id��ѯpaper
	 * @param paper
	 * @return
	 */
	public Paper queryPaperById(String paperId);
	/**
	 * ��ѯȫ��paper
	 * @param paperName TODO
	 * @param paperDescription TODO
	 * @param page TODO
	 * @return
	 */
	public List<Paper> queryPaper(String paperName, String paperDescription, Page page);
	/**
	 * ����paper
	 * @param paper
	 * @return
	 */
	public int updatePaper(Paper paper);
	/**
	 * ɾ��һ��Paper
	 * @param paperId
	 * @return
	 */
	public int delOnePaper(String paperId);
	/**
	 * ��ѯ�Ծ�Ϊ�˿���
	 * @return
	 */
	public List<Paper> queryAllPaper();
	/**
	 * ��ѯ�Ծ�����
	 * @return
	 */
	public int queryCountPaper();
	/**
	 * ����ɾ���Ծ�
	 * @param paperIds
	 * @return
	 */
	public int delBatchPaper(String[] paperIds);
}
