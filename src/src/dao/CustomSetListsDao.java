package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;

import model.Cheer;
import model.CustomSetLists;

/**
 * Servlet implementation class CustomSetListsDao
 */
@WebServlet("/CustomSetListsDao")
public class CustomSetListsDao {

	      public ArrayList<CustomSetLists> getAllBookList(){
		//ここは未実装。
		//CustomSetListsだけを取得するメソッドも必要なので想定だけしておく。
		  return null;
}

	    //タスク一覧を表示し、タスク達成時の褒めるポップアップの設定を表示させる場合のSQL文（階層型）
	      public ArrayList<CustomSetLists> getCustomTagList(){
		   ArrayList<CustomSetLists> custom = new ArrayList<CustomSetLists>();
		   Connection conn = null;

	    		try {
	    			// JDBCドライバを読み込む
	    			Class.forName("org.h2.Driver");

	    			// データベースに接続する
	    			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

	    			// SQL文を準備する
	    			// ここでJOINを利用して2つのテーブルからデータを取得する。
	    			String sql = "select *"
	    					+ " FROM customset_lists"
	    					+ " LEFT JOIN cheer_lists"
	    					+ " ON customset_lists.customset_id = cheer_lists.customset_id";
	    			PreparedStatement pStmt = conn.prepareStatement(sql);

	    			// SQL文を実行し、結果表を取得する
	    			ResultSet rs = pStmt.executeQuery();

	    			// 結果表をコレクションにコピーする
	    			while (rs.next()) {
	    				//結果リストの中に存在しなければCustomSetを１つ追加する
	    				CustomSetLists trgCustomSet = null;
	    				int customsetid = rs.getInt("user_id");

	    				for(CustomSetLists b: custom) {
	    					if(b.getId() == customsetid) {
	    						//見つけた(これまでの処理・行に存在した書籍）
	    						trgCustomSet = b;
	    						//見つけたのでこれ以上のループは必要ない
	    						break;
	    					}
	    				}

	    				if(trgCustomSet == null) {
	    					//見つからなかったので親となる書籍情報を追加
	    					trgCustomSet = new CustomSetLists();
	    					trgCustomSet.setId(rs.getInt("id"));
	    					trgCustomSet.setUser_id(rs.getString("user_id"));
	    					trgCustomSet.setCustomset_id(rs.getString("customset_id"));
	    					trgCustomSet.setCustomset_name(rs.getString("customset_name"));
	    					custom.add(trgCustomSet);
	    				}
	    				//trgCustomSetに１つのreviewを追加
	    				Cheer cheer = new Cheer();
	    				cheer.setId(rs.getInt("id"));
	    				cheer.setUser_id(rs.getString("user_id"));
	    				cheer.setCustomset_id(rs.getString("customset_id"));
	    				cheer.setCheer_image(rs.getString("cheer_image"));
	    				cheer.setCheer_message(rs.getString("cheer_message"));

	    				//現在存在するレビューのリストを取得
	    				ArrayList<Cheer> cheerList = trgCustomSet.getCheers();
	    				cheerList.add(cheer);
	    			}

	    		}catch(Exception ex) {
	    			ex.printStackTrace();
	    			custom = null;
	    		}finally {
	    			// データベースを切断
	    			if (conn != null) {
	    				try {
	    					conn.close();
	    				}
	    				catch (SQLException e) {
	    					e.printStackTrace();
	    					custom = null;
	    				}
	    			}
	    		}
	    		return custom;
	    	}

	     /*
	    				CustomSetLists card = new CustomSetLists(
	    			//カスタムセットリストタグ情報
	    				rs.getString("id"),
	    				rs.getString("user_id"),
	    				rs.getString("customset_id"),
	                    rs.getString("customset_name")

	    				);
	    				List.add(card);
	    				System.out.println(rs.getString("id"));
	    			}
	    		}
	    		catch (SQLException e) {
	    			e.printStackTrace();
	    			List = null;
	    		}
	    		catch (ClassNotFoundException e) {
	    			e.printStackTrace();
	    			List = null;
	    		}
	    		finally {
	    			// データベースを切断
	    			if (conn != null) {
	    				try {
	    					conn.close();
	    				}
	    				catch (SQLException e) {
	    					e.printStackTrace();
	    					List = null;
	    				}
	    			}
	    		}

	    		// 結果を返す
	    		return List;
	    	}
*/
		//新しくタスクを追加する際に使うSQL文
		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(CustomSetLists card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "insert into CustomSet_Lists(user_id,customset_name) values (?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getUser_id() != null && !card.getUser_id().equals("")) {
					pStmt.setString(1, card.getUser_id());
				}
				else {
					pStmt.setString(1, null);
				}

				if (card.getCustomset_name() != null && !card.getCustomset_name().equals("")) {
					pStmt.setString(2, card.getCustomset_name());
				}
				else {
					pStmt.setString(2, null);
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}



		//タスクを編集・更新する際のSQL文
		// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(CustomSetLists card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "update Customset_Lists set id=?, user_id=?, customset_id=?, customset_name=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getId() != null && !card.getId().equals("")) {
					pStmt.setString(1, card.getId());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getUser_id() != null && !card.getUser_id().equals("")) {
					pStmt.setString(2, card.getUser_id());
				}
				else {
					pStmt.setString(2, null);
				}
				if (card.getCustomset_id() != null && !card.getCustomset_id().equals("")) {
					pStmt.setString(3, card.getCustomset_id());
				}
				else {
					pStmt.setString(3, null);
				}
				if (card.getCustomset_name() != null && !card.getCustomset_name().equals("")) {
					pStmt.setString(4, card.getCustomset_name());
				}
				else {
					pStmt.setString(4, null);
				}


				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}

		//タスクリストからタスクを削除する際のSQL文
		// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
		public boolean delete(String id) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "delete from customset_lists where id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				Integer i = Integer.valueOf(id);
				pStmt.setString(1, i.toString());

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}

	}