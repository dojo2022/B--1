package model;
import java.io.Serializable;

public class CustomSetLists implements Serializable {
	private String NAME;	// 新規追加

	public CustomSetLists(String NAME) {
		this.NAME = NAME;
	}

	public CustomSetLists() {
		this.NAME = "";
	}
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	}

