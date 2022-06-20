package model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Users implements Serializable {
	private String id;	// ID
	private String pw;	// PW
	private String date;

	public Users(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	public Users(String id) {
		this.id = id;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat nowDate = new SimpleDateFormat("yyyyMMdd");
		String nowTime = nowDate.format(calendar.getTime());
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}


