package cn.edu.tjut.action;

import java.util.List;

import cn.edu.tjut.po.Student;
import cn.edu.tjut.service.StudentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryStudentAction extends ActionSupport {

	private String sclass;
	
	private StudentService studentService;
	
	private String studentId;
	
	
	
	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getSclass() {
		return sclass;
	}


	public void setSclass(String sclass) {
		this.sclass = sclass;
	}


	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	/**
	 * 通过班级查询学生基本信息
	 * @return
	 */
	public String queryBase(){
		List<Student> students = studentService.queryStudentByClass(sclass);
		ActionContext.getContext().put("students", students);
		return SUCCESS;
	}
	/**
	 * 通过id查询学生详细信息
	 * @return
	 */
	public String queryAll(){
		Student student = studentService.queryStudentById(studentId);
		ActionContext.getContext().put("student", student);
		return "all";
	}
}
