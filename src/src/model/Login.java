package model;

import java.io.Serializable;

public class Login implements Serializable {
	private String id;	// ログイン時のID

	public Login() {
		this(null);
	}

	public Login(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setUserId(String id) {
		this.id = id;
	}
}

