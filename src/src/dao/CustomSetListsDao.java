package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class CustomSetListsDao
 */
@WebServlet("/CustomSetListsDao")
public class CustomSetListsDao {

	// 引数CustomSetNameで指定されたレコードを登録し、成功したらtrueを返す
	 	public boolean insert(CustomSetListsDao CustomSetLists) {
	Connection conn = null;
	boolean result = false;

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

		// カスタムセットnameの新規登録
	String sql = "insert into CustomSetLists (CustomSetLists_NAME) values (?)";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を完成させる
		if (CustomSetLists.getNAME() != null && !CustomSetLists.getNAME().equals("")) {
			pStmt.setString(1, CustomSetLists.getNAME());
		}
		else {
			pStmt.setString(1, null);
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

	private Object getNAME() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}




}
