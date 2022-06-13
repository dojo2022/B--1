package model;

import java.io.Serializable;

public class Memo implements Serializable {
	private int id; // id インクリメント
	private String user_id; // user_id
	private String top_memo; // memoの内容

	/*	引数3つのコンストラクタ*/

		public Memo(int id, String user_id, String top_memo) {
			super();
			this.id = id;
			this.user_id = user_id;
			this.top_memo= top_memo;


		}

		/*引数1つのコンストラクタ*/
	public Memo(String user_id) {
		super();
		this.user_id = user_id;

	}

	/*	引数２つのコンストラクタ*/
	public Memo(String user_id, String top_memo) {
		super();
		this.user_id = user_id;
		this.top_memo = top_memo;

	}

	//引数がないコンストラクタ（デフォルトコンストラクタ）
	public Memo() {
		super();
		this.id = 0;
		this.user_id = "";
		this.top_memo = "";

	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTop_memo() {
		return top_memo;
	}

	public void setTop_memo(String top_memo) {
		this.top_memo = top_memo;
	}

}