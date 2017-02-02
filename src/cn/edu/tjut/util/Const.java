package cn.edu.tjut.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class Const {

	/**
	 * 班级编号与名称
	 */
	public final static String CLASS1_NAME = "1班";
	public final static String CLASS1_NUMBER = "0509301";
	public final static String CLASS2_NAME = "2班";
	public final static String CLASS2_NUMBER = "0509302";
	/**
	 * 默认一页显示的数量
	 */
	public final static int DEFAULT_PAGESHOWNUMBER = 8;
	
	/**
	 * 保存最多的成绩数量
	 */
	public final static int MAX_RESULT = 5;
	/**
	 * ajax请求返回函数
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
