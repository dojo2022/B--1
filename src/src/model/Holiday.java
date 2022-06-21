package model;
import java.io.Serializable;
import java.util.Date;

public class Holiday implements Serializable {
	private int id; 	// id
	private String user_id; 	// user_id
	private Date holiday; 	// date
	private String dayOfWeek; 	// dayOfWeek
	private boolean yesNo;	// yes_or_no

	public Holiday() {
		this.id = 0;
		this.user_id = "";
		this.holiday = null;
		this.dayOfWeek = "";
		this.yesNo = false;
	}

	public Holiday (String user_id) {
		this.id = 0;
		this.user_id = user_id;
		this.holiday = null;
		this.dayOfWeek = "";
		this.yesNo = false;
	}

	public Holiday(String user_id, Date holiday, String DayOfWeek, boolean yesNo) {
		this.id = 0;
		this.user_id = user_id;
		this.holiday = holiday;
		this.dayOfWeek = DayOfWeek;
		this.yesNo = yesNo;
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
	public Date getHoliday() {
		return holiday;
	}
	public void setHoliday(Date holiday) {
		this.holiday = holiday;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public boolean isYesNo() {
		return yesNo;
	}
	public void setYesNo(boolean yesNo) {
		this.yesNo = yesNo;
	}

}