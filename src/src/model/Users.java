package model;
import java.io.Serializable;

public class Users implements Serializable {
	private String id;	// ID
	private String pw;	// PW
	private long date;

	public Users(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	public Users(String id) {
		this.id = id;
		long nowTime = System.currentTimeMillis();
		this.date = nowTime;
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
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
}


