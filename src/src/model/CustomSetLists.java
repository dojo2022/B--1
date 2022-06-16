package model;
import java.io.Serializable;

    //Java Beans

public class CustomSetLists implements Serializable {
	private String id;
    private String user_id;
    private String customset_id;
    private String customset_name;

	//引数があるコンストラクタを作成
	public Task(String id, String user_id, String customset_id, String customset_name)
	{
	super();
	this.id = id;
	this.user_id = user_id;
	this.task_id = customeset_id;
	this.customset_id = customset_name;
	}

	//引数がないコンストラクタを作成
	public CustomSetLists() {
	super();
	this.id = "0";
	this.user_id = "0";
	this.customset_id = "0";
	this.customset_name = "0";
	}

	//ゲッタとセッタ
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setName(String user_id) {
		this.user_id = user_id;
	}

	public String getCustomset_id() {
		return customset_id;
	}

	public void setTask_id(String customset_id) {
		this.customset_id = customset_id;
	}

	public String getCustomset_name() {
		return customset_name;
	}

	public void setCustomset_id(String customset_name) {
		this.customset_id = customset_name;
	}

	public String getTask_name () {
		return customset_name;
	}

	public void setTask_title(String customset_name) {
		this.customset_name = customset_name;
	}

}
