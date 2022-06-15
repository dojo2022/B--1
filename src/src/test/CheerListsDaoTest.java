package test;

import java.util.List;

import dao.CheerListsDao;
import model.Cheer;

public class CheerListsDaoTest {
	public static void main(String[] args) {
		CheerListsDao dao = new CheerListsDao();

		//暗黙的なカレントディレクトリからの相対ファイルパスを
		//データベースURL("jdbc:h2:file:C:dojo6Data/dojo6Data")に指定することは許可されていません。
		//代わりに絶対パスか相対パス( ~/name, ./name)あるいは baseDir を指定して下さい.
		// show()のテスト

		System.out.println("---------- show()のテスト ----------");
		List<Cheer> cheerlist2 = dao.show();
		for (Cheer cheercard : cheerlist2) {
			System.out.println("ID：" + cheercard.getId());
			System.out.println("USER_ID：" + cheercard.getUser_id());
			System.out.println("CUSTOMSET_ID：" + cheercard.getCustomset_id());
			System.out.println("Cheer_image:" + cheercard.getCheer_image());
			System.out.println("Cheer_message:" + cheercard.getCheer_message());
			System.out.println();
		}
	}
}
