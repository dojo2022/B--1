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

	// 引数changeで日付更新
	public boolean change(Remind change) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// 給料日の更新
			if(change.getRemind_name() == "給料日") {
				System.out.println("値：" + change.getRemind_name());
			// SQL文を準備する
			String sql = "update Remind_days set Remind_date = ? where USER_ID = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			java.util.Date date1 = change.getRemind_date();
			String strDate1 = date1.toString();
			String[] dates = strDate1.split("-");

			int intDate = Integer.parseInt(dates[2]);
			int intMonth = Integer.parseInt(dates[1]);
			int intYear = Integer.parseInt(dates[0]);

			if(intMonth < 12) {
				intMonth ++;
			}else {
				intYear ++;
			}

			dates[2] = String.valueOf(intDate);
			dates[1] = String.valueOf(intMonth);
			dates[0] = String.valueOf(intYear);

			String strDate2 = String.join("-", dates);
			Date sqlDate = java.sql.Date.valueOf(strDate2);

			pStmt.setDate(1, sqlDate);

			pStmt.setString(2, change.getUser_id());

			// SQL文を実行する
			pStmt.executeUpdate();
			}

			// 誕生日の更新
			if(change.getRemind_name() == "誕生日") {
			// SQL文を準備する
			String sql = "update Remind_days set Remind_date = ? where USER_ID = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			java.util.Date date1 = change.getRemind_date();
			String strDate1 = date1.toString();
			String[] dates = strDate1.split("-");

			int intDate = Integer.parseInt(dates[2]);
			int intMonth = Integer.parseInt(dates[1]);
			int intYear = Integer.parseInt(dates[0]);

			intYear ++;

			dates[2] = String.valueOf(intDate);
			dates[1] = String.valueOf(intMonth);
			dates[0] = String.valueOf(intYear);

			String strDate2 = String.join("-", dates);
			Date sqlDate = java.sql.Date.valueOf(strDate2);

			pStmt.setDate(1, sqlDate);

			pStmt.setString(2, change.getUser_id());

			// SQL文を実行する
			pStmt.executeUpdate();
			}
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
		return remindList;
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


}