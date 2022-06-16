package model;
import java.io.Serializable;

    //Java Beans

public class Task implements Serializable {
	private String id;
    private String user_id;
    private String task_id;
    private String customset_id;
    private String task_name;
    private String task_memo;
    private String task_date;
    private String priority;
    private String task_judge;



	//引数があるコンストラクタを作成
	public Task(String id, String user_id, String task_id, String customset_id, String task_name, String task_memo, String task_date,
		String priority, String task_judge) {
	super();
	this.id = id;
	this.user_id = user_id;
	this.task_id = task_id;
	this.customset_id = customset_id;
	this.task_name = task_name;
	this.task_memo = task_memo;
	this.task_date = task_date;
	this.priority = priority;
	this.task_judge = task_judge;
	}
	//引数があるコンストラクタを作成
	public Task(String user_id, String task_id, String customset_id, String task_name, String task_memo, String task_date,
		String priority, String task_judge) {
	super();
	this.user_id = user_id;
	this.task_id = task_id;
	this.customset_id = customset_id;
	this.task_name = task_name;
	this.task_memo = task_memo;
	this.task_date = task_date;
	this.priority = priority;
	this.task_judge = task_judge;
	}

	//引数がないコンストラクタを作成
	public Task() {
	super();
	this.id = "0";
	this.user_id = "0";
	this.task_id = "0";
	this.customset_id = "0";
	this.task_name = "0";
	this.task_memo = "0";
	this.task_date = "0";
	this.priority = "0";
	this.task_judge = "0";
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

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public String getCustomset_id() {
		return customset_id;
	}

	public void setCustomset_id(String customset_id) {
		this.customset_id = customset_id;
	}

	public String getTask_name () {
		return task_name;
	}

	public void setTask_title(String task_name) {
		this.task_name = task_name;
	}

	public String getTask_memo() {
		return task_memo;
	}

	public void setTask_memo(String task_memo) {
		this.task_memo = task_memo;
	}

	public String getTask_date() {
		return task_date;
	}

	public void setTask_date(String task_date) {
		this.task_date = task_date;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTask_judge(){
		return task_judge;
	}

	public void setTask_judge(){
		this.task_judge = task_judge;
	}


}
