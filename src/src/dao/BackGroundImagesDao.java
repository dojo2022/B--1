package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import model.BackGround;

@WebServlet("/BackGroundImagesDao")
public class BackGroundImagesDao {

	// 最新のアイコンを取得
			public List<BackGround> select(BackGround select){
				Connection conn = null;
				List<BackGround> backList = new ArrayList<BackGround>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する
					String sql = "select * from background_images WHERE USER_ID = ?  ORDER BY ID DESC LIMIT 1";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					pStmt.setString(1, select.getUser_id());

					// SQL分を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					while (rs.next()) {
						BackGround list = new BackGround(
						rs.getString("USER_ID"),
						rs.getString("BACKGROUND_IMAGE")
						);

						backList.add(list);
					}

				}
				catch (SQLException e) {
					e.printStackTrace();
					backList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					backList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							backList = null;
						}
					}
				}
				// 結果を返す
				return backList;

			}

			// アイコンの画像を登録
			public boolean insert(BackGround insert) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

					// SQL文を準備する
					String sql = "insert into BACKGROUND_IMAGES (USER_ID, BACKGROUND_IMAGE) values (?, ?)";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					pStmt.setString(1, insert.getUser_id());
					pStmt.setString(2, "/Forza/cheer_images/" + insert.getBackground_image());

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


				return result;
			}
		}

