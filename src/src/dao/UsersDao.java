package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

import model.Users;
/**
 * Servlet implementation class UsersDao
 */
@WebServlet("/UsersDao")
public class UsersDao {
	// ログインできるならtrueを返す
	public boolean isLoginOK(Users users) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from Users where ID = ? and PW = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, users.getId());
			pStmt.setString(2, users.getPw());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}
	// パスワードを変更するメソッド
	public boolean isChangePw(String newPw) {
		// IDを設定（デフォルト「DOJO」）
		String Id = "DOJO";
		String resultHash = null;

		// パスワードをSHA-256でハッシュ化
		MessageDigest sha256 = null;
		try {
			sha256 = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		// sha256オブジェクトを利用して、新パスワード newPw のbyte列を取得し、byte配列型 resultsに格納
		byte[] results = sha256.digest(newPw.getBytes());

		// String.format 書式指定"%040x"で、40桁の16進数(256bit)の出力になるようにしている
		// BigIntegerのコンストラクタ 1は正数を指定
		resultHash = String.format("%040x", new BigInteger(1, results));

		// 確認用コンソール出力（デバッグプリント）
		System.out.println(resultHash);

		// DB接続の準備
		Connection conn = null;

		// DB接続の定数定義
		final String JDBC_URL = "jdbc:h2:file:C:/dojo6Data/dojo6Data";
		final String DB_USR = "sa";
		final String DB_PW = "";

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection(JDBC_URL, DB_USR, DB_PW);

			// UPDATE文を準備する
			String sql = "UPDATE IDPW SET pw = ? WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, resultHash);
			pStmt.setString(2, Id);

			// UPDATE文を実行し、結果を取得する
			int updateNum = pStmt.executeUpdate();

			// 実行結果（件数）が１ならパスワード変更成功
			if (updateNum == 1) {
				return true;
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
		return false;
	}
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
 	public boolean insert(Users Users) {
Connection conn = null;
boolean result = false;

try {
	// JDBCドライバを読み込む
	Class.forName("org.h2.Driver");

	// データベースに接続する
	conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

	// Idpwの新規登録
String sql = "insert into USERS (id, pw) values (?, ?)";
	PreparedStatement pStmt = conn.prepareStatement(sql);

	// SQL文を完成させる
	if (Users.getId() != null && !Users.getId().equals("")) {
		pStmt.setString(1, Users.getId());
	}
	else {
		pStmt.setString(1, null);
	}
	if (Users.getPw() != null && !Users.getPw().equals("")) {
		pStmt.setString(2, Users.getPw());
	}
	else {
		pStmt.setString(2, null);
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

}