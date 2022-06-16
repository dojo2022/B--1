package model;
import java.io.Serializable;

public class LoginCount implements Serializable {
	private String id;	// ID
	private int count;

	public LoginCount(String id, int count) {
		this.id = id;
		this.count = count;
	}
	public LoginCount() {
		this.id = "";
		this.count = 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}




}
