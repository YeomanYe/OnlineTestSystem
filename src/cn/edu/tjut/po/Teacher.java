package cn.edu.tjut.po;

/**
 * ��ʦʵ����
 * @author KINGBOOK
 *
 */
public class Teacher implements java.io.Serializable {

	//��ʦID
	private String teacherId;
	//��ʦ����
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