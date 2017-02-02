package cn.edu.tjut.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.tjut.po.Paper;
import cn.edu.tjut.po.Student;
import cn.edu.tjut.po.Subject;
import cn.edu.tjut.po.Teacher;
import cn.edu.tjut.service.PaperService;
import cn.edu.tjut.service.StudentService;
import cn.edu.tjut.service.TeacherService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private PaperService paperService;
	
	private StudentService studentService;
	
	private TeacherService teacherService;
		
	private String username;
	
	private String password;
	
	private String role;
	
	private List<Subject> subjectList;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}
	
	
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public String execute(){
		ActionContext context = ActionContext.getContext();
		Map<String,Object> session = context.getSession();
		
		String retStr = "login";
		Student student = null;
		Teacher teacher = null;
		if(role!=null && !"".equals(role.trim())){
			if(role.equals("student")){
				student = (Student)isUser(role,username,password);
			}
			else if(role.equals("teacher")){
				teacher = (Teacher)isUser(role, username, password);
			}
		}
		if(student!=null){
			//studentLoginDeal(student);
			session.put("student", student);
			retStr = "student";
		}else if(teacher!=null){
			session.put("teacher", teacher);
			retStr="teacher";
		}
		return retStr;
	}

	/**
	 * 检测用户名密码是否正确，返回Teacher或Student对象
	 * @param role
	 * @param username
	 * @param password
	 * @return
	 */
	private Object isUser(String role,String username,String password){
		if(username==null || "".equals(username.trim())){
			return null;
		}
		if(password==null || "".equals(password.trim())){
			return null;
		}
		if(role.equals("student")){
			Student student = studentService.queryStudentById(username);
			if(student!=null){
				password = studentService.queryPassword(password);
				if(student.getPassword().equals(password))return student;
			}
		}
		else if(role.equals("teacher")){
			Teacher teacher = teacherService.queryTeacherById(username);
			if(teacher!=null){
				password = teacherService.queryPassword(password);
				if(teacher.getPassword().equals(password))return teacher;
			}
		}
		return null;
	}
}
