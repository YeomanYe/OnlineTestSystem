package cn.edu.tjut.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.tjut.po.Subject;
import cn.edu.tjut.service.SubjectService;
import cn.edu.tjut.util.Const;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DelSubjectAction extends ActionSupport {

	private SubjectService subjectService;
	
	private Subject subject;

	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}



	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}



	public String delBatch(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] subjectIds = request.getParameterValues("subjectIds");
		int retNum = -1;
		if(subjectIds!=null){
			retNum=subjectService.delBatchSubject(subjectIds);
		}
		Const.outputAjax(retNum, ServletActionContext.getResponse());
		return null;
	}
	
	public String delOne(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String subjectId = request.getParameter("subjectId");
		int retNum = -1;
		if(subjectId!=null && !"".equals(subjectId.trim())){
			retNum = subjectService.delOneSubject(subjectId);
		}
		Const.outputAjax(retNum, ServletActionContext.getResponse());
		return null;
	}
}
