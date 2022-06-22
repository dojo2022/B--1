package model;
import java.io.Serializable;
import java.util.ArrayList;

    //Java Beans

public class CustomSetLists implements Serializable {
	private int id;
    private String user_id;
    private String customset_id;
    private String customset_name;

    private ArrayList<Cheer> cheers = new ArrayList<Cheer>();
	//引数があるコンストラクタを作成
	public CustomSetLists (String id, String user_id, String customset_id, String customset_name)
	{
	super();
	this.id = 0;
	this.user_id = user_id;
	this.customset_id = customset_id;;
	this.customset_name = customset_name;
	}
	//引数があるコンストラクタを作成
	public CustomSetLists ( String user_id,  String customset_name)
	{
	super();
	this.user_id = user_id;
	this.customset_name = customset_name;
	}
	//引数があるコンストラクタを作成(カスタムセットタグの部分）
	public CustomSetLists (String customset_name)
	{
	super();
	this.customset_name = customset_name;
	}
	//引数がないコンストラクタを作成
	public CustomSetLists() {
	super();
	this.id = 0;
	this.user_id = "0";
	this.customset_id = "0";
	this.customset_name = "0";
	}

	//ゲッタとセッタ
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

	public String getCustomset_id() {
		return customset_id;
	}

	public void setCustomset_id(String customset_id) {
		this.customset_id = customset_id;
	}

	public String getCustomset_name() {
		return customset_name;
	}

	public void setCustomset_name(String customset_name) {
		this.customset_id = customset_name;
	}
	public ArrayList<Cheer> getCheers() {
		return cheers;
	}
	public void setCheers(ArrayList<Cheer> cheers) {
		this.cheers = cheers;
	}

}
