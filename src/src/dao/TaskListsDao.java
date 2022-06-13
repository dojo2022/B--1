package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Task;


public class TaskListsDao {
    	public List<Task> show() {
    		Connection conn = null;
    		List<Task> list = new ArrayList<Task>();

    		try {
    			// JDBCドライバを読み込む
    			Class.forName("org.h2.Driver");

    			// データベースに接続する
    			conn = DriverManager.getConnection("jdbc:h2:file:C:dojo6Data/dojo6Data", "sa", "");

    			// SQL文を準備する
    			String sql = "select task_name from task_lists";
    			PreparedStatement pStmt = conn.prepareStatement(sql);

    			// SQL文を実行し、結果表を取得する
    			ResultSet rs = pStmt.executeQuery();

    			// 結果表をコレクションにコピーする
    			while (rs.next()) {
    				Task card = new Task(
    				rs.getString("task_name")
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