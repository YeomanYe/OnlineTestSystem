package cn.edu.tjut.action;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.edu.tjut.model.Page;
import cn.edu.tjut.po.Paper;
import cn.edu.tjut.service.PaperService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 查询paper
 * @author KINGBOOK
 *
 */
public class QueryPaperAction extends ActionSupport {
	
	private Page page;
	
	private PaperService paperService;

	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}

	
	public void setPage(Page page) {
		this.page = page;
	}


	/**
	 * 查询paper
	 */
	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String paperName = request.getParameter("paperName");
		String paperDescription = request.getParameter("paperDescription");
		String strPage = request.getParameter("currentPage");
		int currentPage = 1;
		//获得当前页码
		if(strPage!=null && !"".equals(strPage.trim())){
			Pattern pattern = Pattern.compile("[0-9]{1,}");
			Matcher matcher = pattern.matcher(strPage);
			if(matcher.matches()){
				currentPage = Integer.parseInt(strPage);
			}
		}
		
		page.setCurrentPage(currentPage);
		List<Paper> papers = paperService.queryPaper(paperName, paperDescription, page);
		request.setAttribute("papers", papers);
		request.setAttribute("page", page);
		request.setAttribute("paperName",paperName );
		request.setAttribute("paperDescription", paperDescription);
		return SUCCESS;
	}
	
	
}
