package cn.edu.tjut.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.edu.tjut.po.Student;
import cn.edu.tjut.service.StudentService;
import cn.edu.tjut.util.Const;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private StudentService studentService;
	
	private String regUser;

	private String regPass;

	private String captcha;
	
	private String sclass;
	
	private String againPass;
	
	
	public String getAgainPass() {
		return againPass;
	}

	public void setAgainPass(String againPass) {
		this.againPass = againPass;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getRegUser() {
		return regUser;
	}

	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}

	public String getRegPass() {
		return regPass;
	}

	public void setRegPass(String regPass) {
		this.regPass = regPass;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String submitForm() {
		int retNum = -1;
		HttpServletResponse response = ServletActionContext.getResponse();
		//�����Ƿ���ȷ
		if(check()==0){
			retNum = studentService.addStudent(regUser, regPass,sclass);
			Const.outputAjax(retNum, response);
		}
		return null;
	}
	/**
	 * ����Ϣ���
	 * @return
	 */
	public String checkForm(){
		check();
		return null;
	}
	public int check(){
		int retNum = -1;
		Student student = null;
		 HttpServletResponse response = ServletActionContext.getResponse();
		//�ж��û��������Ƿ�Ϊ��
		if(regUser!=null && !"".equals(regUser.trim())){
			student = studentService.queryStudentById(regUser);
		}else {
			Const.outputAjax(retNum,response);
			return retNum;
		}
		//�ж��û����Ƿ����
		retNum = -2;
		if(student != null){
			Const.outputAjax(retNum, response);
			return retNum;
		}
		//�ж������Ƿ�Ϊ��
		retNum = -3;
		if(regPass==null || "".equals(regPass.trim())){
			Const.outputAjax(retNum, response);
			return retNum;
		}
		//�ж���������������Ƿ�һ��
		retNum = -5;
		if(!regPass.equals(againPass)){
			Const.outputAjax(retNum, response);
			return retNum;
		}
		//�ж���֤���Ƿ���ͬ
		retNum = -4;
		String checkcode = (String)ActionContext.getContext().getSession().get("checkcode");
		if(!checkcode.toUpperCase().equals(captcha.toUpperCase())){
			Const.outputAjax(retNum, response);
			return retNum;
		}
		retNum = 0;
		return retNum;
	}
}
