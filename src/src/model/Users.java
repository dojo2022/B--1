package model;
import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {
	private String id;	// ID
	private String pw;	// PW
	private Date date;

	public Users(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	public Users(String id) {
		this.id = id;
		long nowTime = System.currentTimeMillis();
		Date date = new Date(nowTime);
		this.date = date;
	}

	public Users() {
		this.id = "";
		this.pw = "";
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;


}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}


