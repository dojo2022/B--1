package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

import model.Icon;

@WebServlet("/IconImagesDao")
public class IconImagesDao  {
	// ユーザーのアイコンを選ぶ
	public Icon select(Icon param){
		Connection conn = null;
		Icon iconList = new Icon();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "select * from ICON_IMAGES WHERE USER_ID = ?  ORDER BY ID";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, param.getUser_id());

			// SQL分を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			iconList.setUser_id(rs.getNString("USER_ID"));
			iconList.setIcon_images(rs.getNString("ICON_IMAGES"));

		}
		catch (SQLException e) {
			e.printStackTrace();
			iconList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			iconList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					iconList = null;
				}
			}
		}
		// 結果を返す
		return iconList;
	}
}
