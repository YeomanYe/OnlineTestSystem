package cn.edu.tjut.action;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.tjut.po.Subject;
import cn.edu.tjut.service.SubjectService;
import cn.edu.tjut.util.Const;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaveSubjectAction extends ActionSupport implements
		ModelDriven<Subject> {

	private SubjectService subjectService;

	private Subject subject;

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	/**
	 * ��������
	 * @return
	 */
	public String resetSubject(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("action", "add");
		return SUCCESS;
	}
	/**��������
	 * 
	 * @return
	 */
	public String updateSubject() {
		String retStr = null;
		//�жϸ����Ƿ�ɹ�
		int updateRes = -1;
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getParameter("subjectId")!=null){
			retStr = SUCCESS;
			subject = subjectService.querySubjectById(request.getParameter("subjectId"));
			request.setAttribute("subject", subject);
			request.setAttribute("action", "update");
		}else{
			//��ȡ��ֵ
			String score = request.getParameter("score");
			int subjectScore = 0;
			if(score!=null && !"".equals(score.trim())){
				Pattern pattern = Pattern.compile("[0-9]{1,}");
				Matcher matcher = pattern.matcher(score);
				if(matcher.matches()){
					subjectScore = Integer.parseInt(score);
				}
			}
			subject.setSubjectId(Integer.parseInt(request.getParameter("id")));
			subject.setSubjectScore(subjectScore);
			updateRes = subjectService.updateSubject(subject);
		}
		
		//��һ�ν���ʱ,��Ϊajax����
		if(request.getParameter("subjectId") == null){
			Const.outputAjax(updateRes, ServletActionContext.getResponse());
		}
		return retStr;
	}

	/**
	 * �������
	 * @return
	 * @throws Exception
	 */
	public String addSubject() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String retStr = null;
		if (subject.getSubjectType() != null) {
			
			String score = request.getParameter("score");
			int subjectScore = 0;
			if(score!=null && !"".equals(score.trim())){
				Pattern pattern = Pattern.compile("[0-9]{1,}");
				Matcher matcher = pattern.matcher(score);
				if(matcher.matches()){
					subjectScore = Integer.parseInt(score);
				}
			}
			subject.setSubjectScore(subjectScore);
			int retNum = subjectService.addSubject(subject);
			Const.outputAjax(retNum, ServletActionContext.getResponse());
		}else {
			request.setAttribute("action", "add");
			retStr = SUCCESS;
		}
		return retStr;
	}

	@Override
	public Subject getModel() {
		return subject;
	}

}
