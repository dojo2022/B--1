package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Task;


public class TaskCountDao {

public int TaskCount(Task TaskCount)/*これ何 */{
	Connection conn = null;
	int TaskCount1 = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from TASK_LISTS where USER_ID = ? and task_judge = true";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, TaskCount.getUser_id());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				TaskCount1 = Integer.parseInt(rs.getString("count(*)"));
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
		return TaskCount1;
}
}

