package cn.edu.tjut.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class Const {

	/**
	 * �༶���������
	 */
	public final static String CLASS1_NAME = "1��";
	public final static String CLASS1_NUMBER = "0509301";
	public final static String CLASS2_NAME = "2��";
	public final static String CLASS2_NUMBER = "0509302";
	/**
	 * Ĭ��һҳ��ʾ������
	 */
	public final static int DEFAULT_PAGESHOWNUMBER = 8;
	
	/**
	 * �������ĳɼ�����
	 */
	public final static int MAX_RESULT = 5;
	/**
	 * ajax���󷵻غ���
	 * @param n
	 */
	public static void outputAjax(int n,HttpServletResponse response){
		try {
			response.getWriter().print(n+"");
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	public static void outputAjax(String n,HttpServletResponse response){
		try {
			response.getWriter().print(n);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
