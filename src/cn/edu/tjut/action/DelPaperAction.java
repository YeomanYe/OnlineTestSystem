package cn.edu.tjut.action;

import cn.edu.tjut.service.PaperService;

import com.opensymphony.xwork2.ActionSupport;

public class DelPaperAction extends ActionSupport {

	private PaperService paperService;
	
	private String paperId;
	
	private String[] paperIds;
	
	public String[] getPaperIds() {
		return paperIds;
	}

	public void setPaperIds(String[] paperIds) {
		this.paperIds = paperIds;
	}

	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}
	
	public String delBatchPaper(){
		paperService.delBatchPaper(paperIds);
		return SUCCESS;
	}

	public String delOnePaper(){
		paperService.delOnePaper(paperId);
		return SUCCESS;
	}
}
