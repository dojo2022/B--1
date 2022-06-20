package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cheer;

public class CheerListsDao {
	
    //褒めるポップアップの画像とメッセージをとってくるためのSELECT文↓
    //板垣が書きました
    public List<Cheer> select(Cheer param) {
		Connection conn = null;
		ArrayList<Cheer> cheerList = new ArrayList<Cheer>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を考える（ここが仕事）
			String sql =
			"Select id, user_id, customset_id, cheer_image, cheer_message from CHEER_LISTS WHERE id LIKE ? AND user_id LIKE ? AND customset_id LIKE ? AND cheer_image LIKE ? AND cheer_message LIKE ? ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql); //お約束

			// SQL文を完成させる
			//どんな条件で検索するかを考える
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
			if (param.getCustomset_id() != null) {
				pStmt.setString(3, "%" + param.getCustomset_id() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getCheer_image() != null) {
				pStmt.setString(4, "%" + param.getCheer_image() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}
			if (param.getCheer_message() != null) {
				pStmt.setString(5, "%" + param.getCheer_message() + "%");
			}
			else {
				pStmt.setString(5, "%");
			}

			// SQL文を実行し、結果表を取得する
			//この段階ではまだSQLを読んでない
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) { //whileでnextを行分繰り返している
				Cheer card = new Cheer( //1行分のデータを保持するCheerを生成
				rs.getInt("ID"),
				rs.getString("USER_ID"),
				rs.getString("CUSTOMSET_ID"),
				rs.getString("CHEER_IMAGE"),
				rs.getString("CHEER_MESSAGE")
				);
				cheerList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cheerList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cheerList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cheerList = null;
				}
			}
		}

		// 結果を返す
		return cheerList;
	}
}