package cn.edu.tjut.action;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.ServletActionContext;

import cn.edu.tjut.po.Result;
import cn.edu.tjut.po.Student;
import cn.edu.tjut.service.ResultService;
import cn.edu.tjut.service.StudentService;
import cn.edu.tjut.util.Const;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ResultAction extends ActionSupport {

	private StudentService studentService;
	
	private ResultService resultService;

	private String studentID;
	
	private String stuPass;
	
	private String resultScore;
	
	private String resultID;
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getStuPass() {
		return stuPass;
	}

	public void setStuPass(String stuPass) {
		this.stuPass = stuPass;
	}

	public String getResultScore() {
		return resultScore;
	}

	public void setResultScore(String resultScore) {
		this.resultScore = resultScore;
	}

	public String getResultID() {
		return resultID;
	}

	public void setResultID(String resultID) {
		this.resultID = resultID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}



	public void setResultService(ResultService resultService) {
		this.resultService = resultService;
	}
	/**
	 * 更新成绩
	 * @return
	 */
	public String updateResult(){
		//返回的数字
		int retNum = -1;
		System.out.println(studentID);
		Student student = studentService.queryStudentById(studentID);
		List<Result> results = resultService.queryResultByStudentID(studentID);
		ActionContext.getContext().put("results", results);
		//判断学生密码输入是否正确
		stuPass = studentService.queryPassword(stuPass);
		if(stuPass!=null && stuPass.equals(student.getPassword())){
			if(resultScore!=null && !"".equals(resultScore.trim())){
				//分数规则0-150分之间
				Pattern pattern = Pattern.compile("1[0-4][0-9]|[1-9][0-9]|[0-9]|150");
				Matcher matcher = pattern.matcher(resultScore);
				if(matcher.matches()){
					Result result = resultService.queryResultById(resultID);
					result.setScore(Integer.parseInt(resultScore));
					resultService.updateResult(result);
					
					//计算平均分
					int scoreTotal=0;
					results = resultService.queryResultByStudentID(studentID);
					for(Result r:results){
						scoreTotal += r.getScore();
					}
					//设置平均分
					student.setResult(scoreTotal/results.size());
					//保存平均分
					studentService.updateStudent(student);
					retNum = 0;
				}
			}
		}
		Const.outputAjax(retNum,ServletActionContext.getResponse());
		return null;
	}
	/**
	 * 查询全部成绩
	 * @return
	 */
	public String queryResult(){
		List<Result> results = resultService.queryResultByStudentID(studentID);
		ActionContext.getContext().put("results", results);
		ActionContext.getContext().put("studentID", studentID);
		return SUCCESS;
	}
}
