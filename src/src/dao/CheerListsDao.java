package dao;

import model.Cheer;

public class CheerListsDao {
	//対象ユーザーの１件のランダムな応援メッセージを取得する
	public Cheer getRandomCheer(String user_id) {
		//取得して返却
		return null;
	}

	/*
    //引数paramで検索項目を指定して検索結果のリストを返す
    public List<Cheer> select(Cheer param) {
    	Connection conn = null;
    	List<Cheer> cardList = new ArrayList<Cheer>();

    		try {
    			// JDBCドライバを読み込む
    			Class.forName("org.h2.Driver");

    			// データベースに接続する
    			conn = DriverManager.getConnection("jdbc:h2:file:C:dojo6Data/dojo6Data", "sa", "");

    			// SQL文を準備する
    			String sql =
    			"Select id, user_id, cheer_image, cheer_message from CHEER_LISTS WHERE id LIKE ? AND user_id LIKE ? AND cheer_image LIKE ? AND cheer_message LIKE ? ORDER BY id";
    			PreparedStatement pStmt = conn.prepareStatement(sql);

    			// SQL文を完成させる
    			if (param.getId() != 0) {
    				Integer i = Integer.valueOf(param.getId());
    				pStmt.setString(1, "%" + i.toString() + "%");
    			}
    			else {
    				pStmt.setString(1, "%");
    			}
    			if (param.getUser_id() != null) {
    				pStmt.setString(2, "%" + param.getUser_id() + "%");
    			}
    			else {
    				pStmt.setString(2, "%");
    			}
    			if (param.getCheer_image() != null) {
    				pStmt.setString(3, "%" + param.getCheer_image() + "%");
    			}
    			else {
    				pStmt.setString(3, "%");
    			}
    			if (param.getCheer_message() != null) {
    				pStmt.setString(4, "%" + param.getCheer_message() + "%");
    			}
    			else {
    				pStmt.setString(4, "%");
    			}

    			// SQL文を実行し、結果表を取得する
    			ResultSet rs = pStmt.executeQuery();

    			// 結果表をコレクションにコピーする
    			while (rs.next()) {
    				Cheer card = new Cheer(
    				rs.getInt("ID"),
    				rs.getString("USER_ID"),
    				rs.getString("CHEER_IMAGE"),
    				rs.getString("CHEER_MESSAGE")
    				);
    				cardList.add(card);
    			}
    		}
    		catch (SQLException e) {
    			e.printStackTrace();
    			cardList = null;
    		}
    		catch (ClassNotFoundException e) {
    			e.printStackTrace();
    			cardList = null;
    		}
    		finally {
    			// データベースを切断
    			if (conn != null) {
    				try {
    					conn.close();
    				}
    				catch (SQLException e) {
    					e.printStackTrace();
    					cardList = null;
    				}
    			}
    		}

    		// 結果を返す
    		return cardList;
    	}
    }

    	/*
    	public List<Cheer> show() {
    		Connection conn = null;
    		List<Cheer> list = new ArrayList<Cheer>();

    		try {
    			// JDBCドライバを読み込む
    			Class.forName("org.h2.Driver");

    			// データベースに接続する
    			conn = DriverManager.getConnection("jdbc:h2:file:C:dojo6Data/dojo6Data", "sa", "");

    			// SQL文を準備する
    			String sql = "select id, user_id, cheer_image, cheer_message from CHEER_LISTS";
    			PreparedStatement pStmt = conn.prepareStatement(sql);

    			// SQL文を実行し、結果表を取得する
    			ResultSet rs = pStmt.executeQuery();

    			// 結果表をコレクションにコピーする
    			while (rs.next()) {
    				Cheer card = new Cheer(
    				rs.getInt("id"),
    				rs.getString("user_id"),
    				rs.getString("cheer_image"),
    				rs.getString("cheer_message")
    				);
    				list.add(card);
    				System.out.println(rs.getString("id"));
    			}
    		}
    		catch (SQLException e) {
    			e.printStackTrace();
    			list = null;
    		}
    		catch (ClassNotFoundException e) {
    			e.printStackTrace();
    			list = null;
    		}
    		finally {
    			// データベースを切断
    			if (conn != null) {
    				try {
    					conn.close();
    				}
    				catch (SQLException e) {
    					e.printStackTrace();
    					list = null;
    				}
    			}
    		}

    		// 結果を返す
    		return list;
    	}
    }
}
    	*/
}