package cn.edu.tjut.action;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CaptchaAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		BufferedImage bi = new BufferedImage(70, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		Color c = new Color(255, 155, 10);
		g.setColor(c);
		g.fillRect(0, 0, 70, 30);
		Random r = new Random();
		char[] cs = "ABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		int len = cs.length;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<4;i++){
			int index = r.nextInt(len);
			c = new Color(r.nextInt(100),r.nextInt(150),r.nextInt(255));
			g.setColor(c);
			g.drawString(cs[index]+"", (i*15)+3, 18);
			sb.append(cs[index]);
		}
		ServletActionContext.getResponse().setContentType("image/jpeg;charset=utf-8;");
		ActionContext.getContext().getSession().put("checkcode", sb.toString());
		ImageIO.write(bi, "jpg", ServletActionContext.getResponse().getOutputStream());
		return null;
	}

	
}
