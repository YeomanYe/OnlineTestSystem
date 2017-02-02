package cn.edu.tjut.po;

/**
 * 教师实体类
 * @author KINGBOOK
 *
 */
public class Teacher implements java.io.Serializable {

	//教师ID
	private String teacherId;
	//教师密码
	private String password;


	public Teacher() {
	}

	public Teacher(String teacherId) {
		this.teacherId = teacherId;
	}

	public Teacher(String teacherId, String password) {
		this.teacherId = teacherId;
		this.password = password;
	}


	public String getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}