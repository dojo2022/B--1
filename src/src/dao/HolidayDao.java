package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Holiday;

public class HolidayDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Holiday> select(String user_id) {
			Connection conn = null;
			List<Holiday> DayOfWeek = new ArrayList<Holiday>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する ここ改造
				String sql = "select * from top_memo WHERE user_id =?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる ここ改造

					pStmt.setString(1,user_id);


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする ここ改造

				while (rs.next()) {
					Holiday day = new Holiday(
					rs.getString("user_id"),
					rs.getDate("holiday"),
					rs.getString("dayOfWeek"),
					rs.getBoolean("yesNo")
					);
					DayOfWeek.add(day);
				}



			}
			catch (SQLException e) {
				e.printStackTrace();
				DayOfWeek = null;

			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				DayOfWeek = null;

			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						DayOfWeek = null;

					}
				}
			}

			// 結果を返す
			return DayOfWeek;
		}

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Holiday fight) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "update TOP_MEMO set top_memo =? WHERE user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setBoolean(1,fight.isYesNo());
			pStmt.setString(2,fight.getUser_id());

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



