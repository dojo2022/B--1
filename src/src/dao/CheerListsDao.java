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
    public List<Cheer> show() {
		Connection conn = null;
		List<Cheer> cheerlist = new ArrayList<>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "select id, user_id, customset_id, cheer_image, cheer_message from CHEER_LISTS";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Cheer cheercard = new Cheer(
				rs.getInt("ID"),
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
}