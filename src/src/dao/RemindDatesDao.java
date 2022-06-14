package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Remind;

public class RemindDatesDao {
	// 引数paramで検索項目を指定し、結果のリストを返す
	public List<Remind> select(Remind param){
		Connection conn = null;
		List<Remind> remindList = new ArrayList<Remind>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "select USER_ID REMIND_NAME REMIND_DATE from Remind WHERE USER_ID = ?  ORDER BY ID";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, param.getUser_id());

			// SQL分を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Remind list = new Remind(
				rs.getString("USER_ID"),
				rs.getString("REMIND_NAME"),
				rs.getDate("REMIND_DATE")
				);

				remindList.add(list);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			remindList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			remindList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					remindList = null;
				}
			}
		}
		// 結果を返す
		return remindList;
	}

	// 引数salaryで給料更新
	public boolean salary(Remind salary) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "update Remind_date set Remind_date = ? from remind_dates where USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, salary.getUser_id());

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
	// 引数holidayで休日更新
	public boolean holiday(Remind holiday) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "dateadd(month,1,?) where USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, holiday.getUser_id());

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
	// 引数birthdayで誕生日更新
	public boolean birthday(Remind birthday) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "select adddate where USER_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, birthday.getUser_id());

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

	public List<Remind> choose(Remind choose){
		Connection conn = null;
		List<Remind> remindList = new ArrayList<Remind>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "select USER_ID REMIND_NAME REMIND_DATE from Remind WHERE USER_ID = ? AND REMIND_DATE <= ? ORDER BY ID";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, choose.getUser_id());


	        long miliseconds = System.currentTimeMillis();
	        Date date = new Date(miliseconds);

			pStmt.setDate(2, date);

			// SQL分を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Remind list = new Remind(
				rs.getString("USER_ID"),
				rs.getString("REMIND_NAME"),
				rs.getDate("REMIND_DATE")
				);

				remindList.add(list);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			remindList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			remindList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					remindList = null;
				}
			}
		}
		// 結果を返す
		return remindList;
	}


}