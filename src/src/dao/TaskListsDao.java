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

	//タスク一覧を表示する場合のSQL文
	public List<Task> show() {
    		Connection conn = null;
    		List<Task> list = new ArrayList<Task>();

    		try {
    			// JDBCドライバを読み込む
    			Class.forName("org.h2.Driver");

    			// データベースに接続する
    			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

    			// SQL文を準備する
    			String sql = "select id,user_id,task_id,customset_id,task_name,task_memo,task_date,priority,task_judge from task_lists where task_date =  CURRENT_DATE;";
    			PreparedStatement pStmt = conn.prepareStatement(sql);

    			// SQL文を実行し、結果表を取得する
    			ResultSet rs = pStmt.executeQuery();

    			// 結果表をコレクションにコピーする
    			while (rs.next()) {
    				Task card = new Task(
    				rs.getString("id"),
    				rs.getString("user_id"),
    				rs.getString("task_id"),
    				rs.getString("customset_id"),
    				rs.getString("task_name"),
    				rs.getString("task_memo"),
    				rs.getString("task_date"),
                    rs.getString("priority"),
                    rs.getString("task_judge")
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

	//新しくタスクを追加する際に使うSQL文
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Task card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "insert into Task_Lists(user_id,task_id,customset_id,task_name,task_memo,task_date,priority,task_judge) values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			int taskid;//task_id
			int customsetid;//customset_id
			int priorityNum;//priority
			// SQL文を完成させる
			if (card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setString(1, card.getUser_id());

			}
			else {
				pStmt.setString(1, null);
			}
			/*if (card.getTask_id() != null && !card.getTask_id().equals("")) {
				pStmt.setString(2, card.getTask_id());

			}
			else {}*/
				taskid = Integer.valueOf(card.getTask_id());

				pStmt.setInt(2, taskid);

			if (card.getCustomset_id() != null && !card.getCustomset_id().equals("")) {
				customsetid = Integer.valueOf(card.getCustomset_id());
				pStmt.setInt(3,customsetid );
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getTask_name() != null && !card.getTask_name().equals("")) {
				pStmt.setString(4, card.getTask_name());
			}
			else {
				pStmt.setString(4, null);
			}
			if (card.getTask_memo() != null && !card.getTask_memo().equals("")) {
				pStmt.setString(5, card.getTask_memo());
			}
			else {
				pStmt.setString(5, null);
			}
			if (card.getTask_date() != null && !card.getTask_date().equals("")) {
				pStmt.setString(6, card.getTask_date());
			}
			else {
				pStmt.setString(6, null);
			}
			if (card.getPriority() != null && !card.getPriority().equals("")) {

				priorityNum = Integer.valueOf(card.getPriority());
				pStmt.setInt(7,priorityNum);
			}
			else {
				pStmt.setString(7, null);
			}
			if (card.getTask_judge() != null && !card.getTask_judge().equals("")) {
				pStmt.setString(8, card.getTask_judge());
			}
			else {
				pStmt.setString(8, null);
			}
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

	//タスクを編集・更新する際のSQL文
	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Task card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "update Task_Lists set user_id=?, task_id=?, customset_id=?, task_name=?, task_memo=?, task_date=?, priority=?, task_judge=? where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setString(1, card.getUser_id());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getTask_id() != null && !card.getTask_id().equals("")) {
				pStmt.setString(2, card.getTask_id());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getCustomset_id() != null && !card.getCustomset_id().equals("")) {
				pStmt.setString(3, card.getCustomset_id());
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getTask_name() != null && !card.getTask_name().equals("")) {
				pStmt.setString(4, card.getTask_name());
			}
			else {
				pStmt.setString(4, null);
			}
			if (card.getTask_memo() != null && !card.getTask_memo().equals("")) {
				pStmt.setString(5, card.getTask_memo());
			}
			else {
				pStmt.setString(5, null);
			}
			if (card.getTask_date() != null && !card.getTask_date().equals("")) {
				pStmt.setString(6, card.getTask_date());
			}
			else {
				pStmt.setString(6, null);
			}
			if (card.getPriority() != null && !card.getPriority().equals("")) {
				pStmt.setString(7, card.getPriority());
			}
			else {
				pStmt.setString(7, null);
			}
			if (card.getTask_judge() != null && !card.getTask_judge().equals("")) {
				pStmt.setString(8, card.getTask_judge());
			}
			else {
				pStmt.setString(8, null);
			}
			pStmt.setString(9, card.getId());

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

	//タスクリストからタスクを削除する際のSQL文
	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(String id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "delete from task_lists where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			Integer i = Integer.valueOf(id);
			pStmt.setString(1, i.toString());

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
