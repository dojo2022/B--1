package model;

import java.io.Serializable;

import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class BackGround
 */
@WebServlet("/BackGround")
public class BackGround implements Serializable {
	private int id;
	private String user_id;
	private String background_image;

	public BackGround() {
		this.id = 0;
		this.user_id = "";
		this.background_image = "";
	}

	public BackGround(String user_id,String background_image) {
		this.id = 0;
		this.user_id = user_id;
		this.background_image = background_image;
	}

	public BackGround(String user_id) {
		this.user_id = user_id;
		this.background_image = "";
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

	public String getBackground_image() {
		return background_image;
	}

	public void setBackground_image(String background_image) {
		this.background_image = background_image;
	}
}
