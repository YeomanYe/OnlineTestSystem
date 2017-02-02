package cn.edu.tjut.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.tjut.po.Paper;
import cn.edu.tjut.po.Result;
import cn.edu.tjut.po.Student;
import cn.edu.tjut.po.Subject;
import cn.edu.tjut.service.PaperService;
import cn.edu.tjut.service.ResultService;
import cn.edu.tjut.service.StudentService;
import cn.edu.tjut.util.Const;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StudentOperateAction extends ActionSupport {

	private StudentService studentService;

	private PaperService paperService;
	
	private ResultService resultService;
	
	private List<Subject> subjectList;

	private String studentName;
	
	private String studentAge;
	
	private String studentSex;
	
	private String studentEmail;
	
	private String paperId;
	
	public String getPaperId() {
		return paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	public void setResultService(ResultService resultService) {
		this.resultService = resultService;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}

	public String queryBaseInfo() {
		return "queryBaseInfo";
	}
	
	public String queryScore(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		//���ѧ��ID
		Student student = (Student)session.get("student");
		String stuID = student.getStudentID();
		List<Result> results = resultService.queryResultByStudentID(stuID);
		ActionContext.getContext().put("results", results);
		return "queryScore";
	}
	
	public String queryPaper(){
		//��ѯPaper
		List<Paper> papers = paperService.queryAllPaper();
		ActionContext.getContext().put("papers", papers);
		return "queryPaper";
	}
	
	public String executeTest(){
		ActionContext context = ActionContext.getContext();
		Map<String,Object> session = context.getSession();
		//�����δ�����Ծ��������Ծ�
		if(session.get("paperId")==null || !session.get("paperId").equals(paperId)){
			Paper paper = paperService.queryPaperById(paperId);
			
			context.put("paper", paper);
			//���ɹ̶���Ŀ�б�
			Set<Subject> subjects = paper.getSubjects();
			Iterator<Subject> iterator = subjects.iterator();
			while(iterator.hasNext()){
				Subject subject = (Subject)iterator.next();
				subjectList.add(subject);
			}
			
			context.getSession().put("subjectList", subjectList);
			session.put("paperScore", paper.getPaperScore());
			session.put("paperName", paper.getPaperName());	
			session.put("paperId", paperId);
		}
		return "executeTest";
	}
	
	public String updateStudentInfo(){
		int ret = -1;
		Map session = ActionContext.getContext().getSession();
		Student student = (Student)session.get("student");
		HttpServletResponse response = ServletActionContext.getResponse();
		//����ѧ����Ϣ
		
		Pattern pattern = null;
		Matcher matcher = null;
		if(studentAge!=null && !"".equals(studentAge.trim())){
			//�Ϸ�������һ��150��֮��
			 pattern = Pattern.compile("[1-9]|[1-9][0-9]|1[0-4][0-9]|150");
			 matcher = pattern.matcher(studentAge);
			 if(matcher.matches()){
				 student.setStudentAge(Integer.parseInt(studentAge));
			 }else{
				 Const.outputAjax(ret, response);
				 return null;
			 }
		}
		if(studentEmail!=null && !"".equals(studentEmail.trim())){
			//ƥ������
			 pattern = Pattern.compile("[\\S]*@([0-9a-zA-Z]{1,})[.][a-z]*");
			 matcher = pattern.matcher(studentEmail);
			 if(matcher.matches()){
				 student.setStudentEmail(studentEmail);
			 }else{
				 Const.outputAjax(ret, response);
				 return null;
			 }
		}
		if(Integer.parseInt(studentSex)==1){
			student.setStudentSex(true);
		}else{
			student.setStudentSex(false);
		}
		student.setStudentName(studentName);
		//����ѧ����Ϣ
		ret = studentService.updateStudent(student);
		Const.outputAjax(ret, response);
		return null;
	}
}
