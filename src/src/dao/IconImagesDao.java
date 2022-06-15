package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import model.Icon;

@WebServlet("/IconImagesDao")
public class IconImagesDao  {

	// 最新のアイコンを取得
	public List<Icon> select(Icon select){
		Connection conn = null;
		List<Icon> iconList = new ArrayList<Icon>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "select * from icon_images WHERE USER_ID = ?  ORDER BY ID LIMIT 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, select.getUser_id());

			// SQL分を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Icon list = new Icon(
				rs.getString("USER_ID"),
				rs.getString("ICON_IMAGE")
				);

				iconList.add(list);
			}

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
