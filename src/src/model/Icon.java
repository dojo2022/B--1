package model;

import java.io.Serializable;

import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Icon
 */
@WebServlet("/Icon")
public class Icon implements Serializable {
	private int id;
	private String user_id;
	private String icon_image;

	public Icon() {
		this.id = 0;
		this.user_id = "";
		this.icon_image = "";
	}

	public Icon(String user_id,String icon_image) {
		this.id = 0;
		this.user_id = user_id;
		this.icon_image = icon_image;
	}

	public Icon(String user_id) {
		this.user_id = user_id;
		this.icon_image = "";
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getIcon_image() {
		return icon_image;
	}
	public void setIcon_image(String icon_image) {
		this.icon_image = icon_image;
	}

}
