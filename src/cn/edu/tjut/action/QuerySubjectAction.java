package cn.edu.tjut.action;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.tjut.model.Page;
import cn.edu.tjut.po.Subject;
import cn.edu.tjut.service.SubjectService;

import com.opensymphony.xwork2.ActionSupport;

public class QuerySubjectAction extends ActionSupport{

	private SubjectService subjectService;
	
	private Page page;

	public void setPage(Page page) {
		this.page = page;
	}

	/**
	 * 查询试题
	 */
	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();

		
		String subjectType = request.getParameter("subjectType");
		String subjectTitle = request.getParameter("subjectTitle");
		String strPage = request.getParameter("currentPage");
		System.out.println("subjectType:"+subjectType+",subjectTttle:"+subjectTitle+",currentPage:"+strPage);
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
		List<Subject> subjects = subjectService.querySubject(subjectType, subjectTitle, page);
		request.setAttribute("subjects", subjects);
		request.setAttribute("page", page);
		request.setAttribute("subjectType",subjectType );
		request.setAttribute("subjectTitle", subjectTitle);
		return SUCCESS;
	}

	
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}


	public SubjectService getSubjectService() {
		return subjectService;
	}

}
