package cn.edu.tjut.dao;

import java.util.List;

import cn.edu.tjut.model.Page;
import cn.edu.tjut.po.Paper;

public interface PaperDao {

	/**
	 * ����Ծ�
	 * @param paper
	 */
	public void addPaper(Paper paper);
	
	/**
	 * ͨ��id��ѯ�Ծ�
	 * @param paperId
	 * @return 
	 */
	public Paper queryPaperById(String paperId);
	/**
	 * ��ѯpaper
	 * @param paperName TODO
	 * @param paperDescription TODO
	 * @param page TODO
	 * @return
	 */
	public List<Paper> queryPaper(String paperName, String paperDescription, Page page);
	/**
	 * ����Paper
	 * @param paper
	 */
	public void updatePaper(Paper paper);
	/**
	 * ɾ��һ���Ծ�
	 * @param paper
	 */
	public void delOnePaper(Paper paper);
	/**
	 * ��ѯȫ������
	 * @return
	 */
	public List<Paper> queryAllPaper();
	/**
	 * ��ѯPaper����
	 * @return
	 */
	public int queryCountPaper();
	/**
	 * ����ɾ��
	 * @param paperIds
	 */
	public void delBatchPaper(String[] paperIds);
}
