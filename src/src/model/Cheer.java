package model;
import java.io.Serializable;

public class Cheer implements Serializable {
	private int id;	// 整理番号
	private String user_id;	// ユーザーID
	private int customset_id;//カスタムセットID
	private String cheer_image; //応援画像
	private String cheer_message; //応援メッセージ

	//引数があるコンストラクタを作成
	public Cheer(int id, String user_id, int customset_id, String cheer_image, String cheer_message) {
	super();
	this.id = id;
    this.user_id = user_id;
    this.customset_id = customset_id;
    this.cheer_image = cheer_image;
    this.cheer_message = cheer_message;
	}

	public Cheer(String cheer_image,String cheer_message) {
		super();
		this.cheer_image = cheer_image;
        this.cheer_message = cheer_message;
		}

	//引数がないコンストラクタを作成
	public Cheer() {
	super();
	this.id = 0;
	this.user_id = "";
	this.customset_id = 0;
	this.cheer_image = "";
	this.cheer_message = "";
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

	public int getCustomset_id() {
		return customset_id;
	}

	public void setCustomset_id(int customset_id) {
		this.customset_id = customset_id;
	}

	public String getCheer_image() {
		return cheer_image;
	}

	public void setCheer_image(String cheer_image) {
		this.cheer_image = cheer_image;
	}

	public String getCheer_message() {
		return cheer_message;
	}

	public void setCheer_message(String cheer_message) {
		this.cheer_message = cheer_message;
	}
}
