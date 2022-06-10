package model;

import java.io.Serializable;

public class Users implements Serializable {
	private String id;	// ログイン時のID

	public Users() {
		this(null);
	}

	public Users(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setUserId(String id) {
		this.id = id;
	}
}