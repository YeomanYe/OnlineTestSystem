package cn.edu.tjut.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.edu.tjut.po.Result;
import cn.edu.tjut.po.Student;
import cn.edu.tjut.po.Subject;
import cn.edu.tjut.service.ResultService;
import cn.edu.tjut.service.StudentService;
import cn.edu.tjut.service.SubjectService;
import cn.edu.tjut.util.Const;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ExamAction extends ActionSupport {

	private ResultService resultService;
	
	private SubjectService subjectService;
	
	private StudentService studentService;
	
	private List<String> studentAnswer;
	
	private Result result;
	
	

	public void setResult(Result result) {
		this.result = result;
	}
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	public void setResultService(ResultService resultService) {
		this.resultService = resultService;
	}



	public void setStudentAnswer(List<String> studentAnswer) {
		this.studentAnswer = studentAnswer;
	}



	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}



	public String execute(){
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)context.get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
		int totalScore = 0;
		context.getSession().put("totalScore", totalScore);
		for(int i=0;;i++){
			//获得SubjectId
			String temp = "subject_"+i+"_id";
			String subjectId = (String)request.getParameter(temp);
			//判断id是否为空
			if(subjectId==null || "".equals(subjectId)){
				break;
			}
			
			Subject subject = subjectService.querySubjectById(subjectId);
			
			//获得学生答案
			String stuAns = (String)request.getParameter("subject_"+i);
			studentAnswer.add(stuAns);
			context.getSession().put("studentAnswer", studentAnswer);
			//求分数总值
			if(stuAns.equals(subject.getSubjectAnswer().toUpperCase())){
				totalScore += subject.getSubjectScore();
				context.getSession().put("totalScore", totalScore);
			}
		}
		dealResult(totalScore);
		return SUCCESS;
	}
	
	private void dealResult(int totalScore){
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		Student student  = (Student)session.get("student");
		//设置成绩信息
		result.setScore(totalScore);
		result.setPaperName((String)session.get("paperName"));
		result.setStudentID(student.getStudentID());
		result.setStudent(student);
		result.setTime(new Date());
		resultService.addResult(result);
		//获得全部成绩
		List<Result> resultList = resultService.queryResultByStudentID(student.getStudentID());
		if(resultList.size()>Const.MAX_RESULT){
			Result firstRes = resultList.get(0);
			resultService.delResult(firstRes);
			resultList.remove(firstRes);
		}
		int temp = 0;
		for(int i=0;i<resultList.size();i++){
			temp += resultList.get(i).getScore();
		}
		//更新平均成绩
		student.setResult(temp/resultList.size());
		//更新学生
		studentService.updateStudent(student);
	}
}
