package model;
import java.io.Serializable;
import java.util.Date;

public class Remind implements Serializable {
	private int id; 	// id
	private String user_id; 	// user_id
	private String remind_name; 	// name
	private Date remind_date; 	// date

	public Remind(int id, String user_id, String remind_name, java.sql.Date remind_date) {
		this.id = id;
		this.user_id = user_id;
		this.remind_name = remind_name;
		this.remind_date = remind_date;
	}

	public Remind( String user_id, String remind_name, java.sql.Date remind_date) {
		this.user_id = user_id;
		this.remind_name = remind_name;
		this.remind_date = remind_date;
	}

	public Remind(String user_id) {
		this.id = null;
		this.user_id = user_id;
		this.remind_name = null;
		this.remind_date = null;
	}


	public Remind() {
		this.id = 0;
		this.user_id = "";
		this.remind_name = "";
		this.remind_date = null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getRemind_name() {
		return remind_name;
	}

	public void setRemind_name(String remind_name) {
		this.remind_name = remind_name;
	}

	public Date getRemind_date() {
		return remind_date;
	}

	public void setRemind_date(Date remind_date) {
		this.remind_date = remind_date;
	}


}