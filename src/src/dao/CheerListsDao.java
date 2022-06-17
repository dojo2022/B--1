package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cheer;
import model.Icon;

public class CheerListsDao {
    public List<Cheer> show(String customset_id) {
		Connection conn = null;
		List<Cheer> cheerlist = new ArrayList<Cheer>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "select id, user_id, customset_id, cheer_image, cheer_message from CHEER_LISTS WHERE customset_id=? LIMIT 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			//SQL文を完成させる
			Integer i = Integer.valueOf(customset_id);
			pStmt.setString(1, i.toString());

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Cheer cheercard = new Cheer(
				rs.getString("ID"),
				rs.getString("USER_ID"),
				rs.getString("CUSTOMSET_ID"),
				rs.getString("CHEER_IMAGE"),
				rs.getString("CHEER_MESSAGE")
				);
				cheerlist.add(cheercard);
				System.out.println(rs.getInt("ID"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cheerlist = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cheerlist = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cheerlist = null;
				}
			}
		}

		// 結果を返す
		return cheerlist;
	}

 // 最新のアイコンを取得
 	public List<Icon> select(Icon select){
 		Connection conn = null;
 		List<Icon> iconList = new ArrayList<Icon>();

 		try {
 			// JDBCドライバを読み込む
 			Class.forName("org.h2.Driver");

 			// データベースに接続する
 			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

 			// SQL文を準備する
 			String sql = "select * from icon_images WHERE USER_ID = ?  ORDER BY ID DESC LIMIT 1";
 			PreparedStatement pStmt = conn.prepareStatement(sql);

 			// SQL文を完成させる
 			pStmt.setString(1, select.getUser_id());

 			// SQL分を実行し、結果表を取得する
 			ResultSet rs = pStmt.executeQuery();

 			while (rs.next()) {
 				Icon list = new Icon(
 				rs.getString("USER_ID"),
 				rs.getString("ICON_IMAGE")
 				);

 				iconList.add(list);
 			}

 		}
 		catch (SQLException e) {
 			e.printStackTrace();
 			iconList = null;
 		}
 		catch (ClassNotFoundException e) {
 			e.printStackTrace();
 			iconList = null;
 		}
 		finally {
 			// データベースを切断
 			if (conn != null) {
 				try {
 					conn.close();
 				}
 				catch (SQLException e) {
 					e.printStackTrace();
 					iconList = null;
 				}
 			}
 		}
 		// 結果を返す
 		return iconList;

 	}

 	// アイコンの画像を登録
 	public boolean insert(Icon insert) {
 		Connection conn = null;
 		boolean result = false;

 		try {
 			// JDBCドライバを読み込む
 			Class.forName("org.h2.Driver");

 			// データベースに接続する
 			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

 			// SQL文を準備する
 			String sql = "insert into icon_images (user_id, icon_image) values (?, ?)";
 			PreparedStatement pStmt = conn.prepareStatement(sql);

 			// SQL文を完成させる
 			pStmt.setString(1, insert.getUser_id());
 			pStmt.setString(2, "/Forza/icon_images/" + insert.getIcon_image());

 				result = true;

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


 		return result;
 	}
}