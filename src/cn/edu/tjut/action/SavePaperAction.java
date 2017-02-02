package cn.edu.tjut.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.collection.internal.PersistentSet;

import cn.edu.tjut.model.Page;
import cn.edu.tjut.po.Paper;
import cn.edu.tjut.po.Subject;
import cn.edu.tjut.service.PaperService;
import cn.edu.tjut.service.SubjectService;
import cn.edu.tjut.util.Const;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SavePaperAction extends ActionSupport implements
		ModelDriven<Paper> {

	private List<Subject> batchSubjects;
	
	private SubjectService subjectService;

	private Page page;

	private Paper paper;

	private PaperService paperService;
	
	public void setBatchSubjects(List<Subject> batchSubjects) {
		this.batchSubjects = batchSubjects;
	}

	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public Paper getModel() {
		return paper;
	}
	/**
	 * 检查试卷
	 * @return
	 */
	public String checkPaper() {
		return "check";
	}
	
	/**
	 * 从试卷中删除试题
	 * @return
	 */
	public String delSubjectFromPaper(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String subjectId = request.getParameter("subjectId");
		
		Paper paper1 = (Paper)session.getAttribute("paper");
		String actions = (String)session.getAttribute("actions");
		
		Iterator iterator = null;
		
		if(actions.equals("update")){
			PersistentSet subjects =  (PersistentSet)paper1.getSubjects();
			iterator = subjects.iterator();
			while(iterator.hasNext()){
				Subject s = (Subject)iterator.next();
				if(s.getSubjectId() == Integer.parseInt(subjectId)){
					//修改题目数量，试卷分值
					paper1.setPaperScore(paper1.getPaperScore()-s.getSubjectScore());
					paper1.setPaperSubjectNumber(paper1.getPaperSubjectNumber()-1);
					subjects.remove(s);
					break;
				}
			}
		}else if(actions.equals("add")){
 			HashSet<Subject> subjects =  (HashSet<Subject>)paper1.getSubjects();
			iterator = subjects.iterator();
			while(iterator.hasNext()){
				Subject s = (Subject)iterator.next();
				System.out.println(s.getSubjectId()==Integer.parseInt(subjectId));
				if(s.getSubjectId()==Integer.parseInt(subjectId)){
					//修改题目数量，试卷分值
					paper1.setPaperScore(paper1.getPaperScore()-s.getSubjectScore());
					paper1.setPaperSubjectNumber(paper1.getPaperSubjectNumber()-1);
					subjects.remove(s);
					break;
				}
			}
		}

		
		return "check";
	}
	/**
	 * 更新试卷
	 * @return
	 */
	public String updatePaper(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Paper paper1 = (Paper)session.getAttribute("paper");
		
		//设置编辑人、试卷名、试卷描述、修改时间
		paper1.setPaperAuthor(paper.getPaperAuthor());
		paper1.setPaperDescription(paper.getPaperDescription());
		paper1.setPaperName(paper.getPaperName());
		paper1.setPaperUpdateDate(new Date());
		
		int retNum = paperService.updatePaper(paper1);
		Const.outputAjax(retNum, ServletActionContext.getResponse());
		return null;
	}
	/**
	 * 保存paper
	 * 
	 * @return
	 */
	public String addPaper() {
		// 获取session中保存的paper
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int retNum = -1;
		Paper paper1 = (Paper) session.getAttribute("paper");
		//没有添加任何试题时
		if(paper1==null || paper1.getSubjects().size() == 0){
			Const.outputAjax(retNum,ServletActionContext.getResponse());
			return null;
		}
		// 设置paper各种属性
		paper1.setPaperAuthor(paper.getPaperAuthor());
		paper1.setPaperDescription(paper.getPaperDescription());
		paper1.setPaperName(paper.getPaperName());
		paper1.setPaperCreateDate(new Date());
		paper1.setPaperUpdateDate(new Date());

		retNum = paperService.addPaper(paper1);
		Const.outputAjax(retNum,ServletActionContext.getResponse());
		return null;
	}
	/**
	 * 批量添加试题
	 * @return
	 */
	public String addBatchSubjects(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("paper") == null) {
			session.setAttribute("paper", new Paper());
		}
		// 取得放在request中的paper
		Paper paper1 = (Paper) session.getAttribute("paper");
		// 设置paper各种属性
		if (paper.getPaperAuthor()!=null && !"".equals(paper.getPaperAuthor().trim())) {
			paper1.setPaperAuthor(paper.getPaperAuthor());
		}
		if(paper.getPaperDescription()!=null && !"".equals(paper.getPaperDescription().trim())){
			paper1.setPaperDescription(paper.getPaperDescription());
		}
		if(paper.getPaperName()!=null && !"".equals(paper.getPaperName().trim())){
			paper1.setPaperName(paper.getPaperName());
		}
		String[] subjectIds = request.getParameterValues("subjectIds");
		//获取所有题目，计算题目分数之和
		int allSubjectScore = 0;
		for(int i=0;i<subjectIds.length;i++){
			Subject subject = subjectService.querySubjectById(subjectIds[i]);
			allSubjectScore+=subject.getSubjectScore();
			batchSubjects.add(subject);
		}
		//设置分数，题量
		paper1.setPaperSubjectNumber(paper1.getPaperSubjectNumber()+batchSubjects.size());
		paper1.setPaperScore(paper1.getPaperScore()+allSubjectScore);
		Set<Subject> paperSubjects = paper1.getSubjects();
		for(Subject s:batchSubjects){
			paperSubjects.add(s);
		}
		query();
		return SUCCESS;
	}
	
	/**
	 * 添加试题到paper
	 * 
	 * @return
	 */
	public String addSubject() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("paper") == null) {
			session.setAttribute("paper", new Paper());
		}
		// 取得放在request中的paper
		Paper paper1 = (Paper) session.getAttribute("paper");
		// 设置paper各种属性
		if (paper.getPaperAuthor()!=null && !"".equals(paper.getPaperAuthor().trim())) {
			paper1.setPaperAuthor(paper.getPaperAuthor());
		}
		if(paper.getPaperDescription()!=null && !"".equals(paper.getPaperDescription().trim())){
			paper1.setPaperDescription(paper.getPaperDescription());
		}
		if(paper.getPaperName()!=null && !"".equals(paper.getPaperName().trim())){
			paper1.setPaperName(paper.getPaperName());
		}
		// 获取subject对象
		Subject subject = subjectService.querySubjectById(request
				.getParameter("subjectId"));
		//设置分值与题量
		paper1.setPaperScore(paper1.getPaperScore() + subject.getSubjectScore());
		paper1.setPaperSubjectNumber(paper1.getPaperSubjectNumber() + 1);
		Set<Subject> subjects = paper1.getSubjects();
		subjects.add(subject);
		query();
		return SUCCESS;
	}

	/**
	 * 查询试题
	 * 
	 * @return
	 */
	public String querySubject() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("actions")==null || "".equals(session.getAttribute("actions"))){
			session.setAttribute("actions", "add");
		}
		query();
		return SUCCESS;
	}

	/**
	 * 查询,显示列表函数
	 */
	private void query() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String subjectType = request.getParameter("subjectType");
		String subjectTitle = request.getParameter("subjectTitle");
		String strPage = request.getParameter("currentPage");
		int currentPage = 1;

		if (strPage != null && !"".equals(strPage.trim())) {
			Pattern pattern = Pattern.compile("[0-9]{1,}");
			Matcher matcher = pattern.matcher(strPage);
			if (matcher.matches()) {
				currentPage = Integer.parseInt(strPage);
			}
		}

		page.setCurrentPage(currentPage);
		List<Subject> subjects = subjectService.querySubject(subjectType,
				subjectTitle, page);
		request.setAttribute("subjects", subjects);
		request.setAttribute("page", page);
		request.setAttribute("subjectType", subjectType);
		request.setAttribute("subjectTitle", subjectTitle);
	}

	/**
	 * 查询要更新的paper
	 * 
	 * @return
	 */
	public String queryPaperForUpdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String paperId = request.getParameter("paperId");
		Paper paper1 = paperService.queryPaperById(paperId);
		session.setAttribute("paper", paper1);
		session.setAttribute("actions", "update");
		return "update";
	}

	/**
	 * 重置paper
	 * 
	 * @return
	 */
	public String resetPaper() {
		query();
		// 清空保存的paper
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("paper", null);
		session.setAttribute("actions", "add");
		return SUCCESS;
	}
}
