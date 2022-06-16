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
			String sql = "select * from Remind_days WHERE USER_ID = ?  ORDER BY ID";
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

	// 引数changeでchooseで選ばれた日付更新
	public boolean change(Remind change) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// 給料日の更新
			switch(change.getRemind_name() ) {
			case "給料日":
				// SQL文を準備する
				String sql = "update Remind_days set Remind_date = ? where USER_ID = ? ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				java.util.Date date1 = change.getRemind_date();

				System.out.println(change.getRemind_date());

				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date1);
				calendar.add(Calendar.MONTH, 1);
				date1 = calendar.getTime();

		        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        String formattedDate = simpleDateFormat.format(date1);
		        java.sql.Date date2 = java.sql.Date.valueOf(formattedDate);

				pStmt.setDate(1, date2);
				pStmt.setString(2, change.getUser_id());

				// SQL文を実行する
				pStmt.executeUpdate();

				break;

			// 誕生日の更新
			case "誕生日":
				// SQL文を準備する
				String sql2 = "update Remind_days set Remind_date = ? where USER_ID = ? ";
				PreparedStatement pStmt2 = conn.prepareStatement(sql2);

				java.util.Date date3 = change.getRemind_date();
				Calendar calendar2 = Calendar.getInstance();
				calendar2.setTime(date3);
				calendar2.add(Calendar.YEAR, 1);
				date3 = calendar2.getTime();

		        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

		        String formattedDate2 = simpleDateFormat2.format(date3);

		        java.sql.Date date4 = java.sql.Date.valueOf(formattedDate2);

				pStmt2.setDate(1, date4);
				pStmt2.setString(2, change.getUser_id());

				// SQL文を実行する
				pStmt2.executeUpdate();

				break;
			}

			result = true;
			System.out.println(result);

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
	public List<Remind> choose(Remind choose){
		Connection conn = null;
		List<Remind> remindList = new ArrayList<Remind>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "select * from Remind_days WHERE USER_ID = ? AND REMIND_DATE <= ? ORDER BY ID";
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

	public boolean insert(Remind insert) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "insert into remind_days (user_id, remind_date) values (?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setString(1, insert.getUser_id());

				long miliseconds = System.currentTimeMillis();
		        Date date = new Date(miliseconds);

				pStmt.setDate(2, date);

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