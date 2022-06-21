package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

				// SQL文を準備する
				String sql = "select * from holiday WHERE user_id =?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる

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

	// 引数fightで指定されたレコードを更新し、成功したらtrueを返す(正誤判定)
	public boolean fight(Holiday fight) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "update holiday set yesNo = ? WHERE user_id = ? and dayofweek = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setBoolean(1,fight.isYesNo());
				pStmt.setString(2,fight.getUser_id());
				pStmt.setString(3,fight.getDayOfWeek());

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
	// 引数chooseで今日より前の日付を選択
	public List<Holiday> choose(Holiday choose){
		Connection conn = null;
		List<Holiday> holiday = new ArrayList<Holiday>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "select * from holiday WHERE USER_ID = ? AND holiday < ? ORDER BY ID";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, choose.getUser_id());


	        long miliseconds = System.currentTimeMillis();
	        Date date = new Date(miliseconds);

			pStmt.setDate(2, date);

			// SQL分を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Holiday day = new Holiday(
				rs.getString("USER_ID"),
				rs.getDate("HOLIDAY"),
				rs.getString("DAYOFWEEK"),
				rs.getBoolean("YESNO")
				);

				holiday.add(day);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			holiday = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			holiday = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					holiday = null;
				}
			}
		}
		// 結果を返す
		return holiday;
	}

	// 引数updateで指定したレコードを更新(1週間後)
	public boolean update(Holiday update) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbv:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文の準備
			String sql = "update holiday set holiday = ? WHERE user_id = ? AND dayofweek = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			java.util.Date date1 = update.getHoliday();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date1);
			calendar.add(Calendar.DATE, 7);
			date1 = calendar.getTime();
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
	        String formattedDate = simpleDateFormat.format(date1);
	        Date date2 = Date.valueOf(formattedDate);

			pStmt.setDate(1, date2);
			pStmt.setString(2, update.getUser_id());
			pStmt.setString(3, update.getDayOfWeek());

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

		return result;
	}
}