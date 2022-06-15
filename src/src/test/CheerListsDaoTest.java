package test;

import java.util.List;

import dao.CheerListsDao;
import model.Cheer;

public class CheerListsDaoTest {
	public static void main(String[] args) {
		CheerListsDao dao = new CheerListsDao();

		// show()のテスト

		System.out.println("---------- show()のテスト ----------");
		List<Cheer> cheerlist = dao.show();
		for (Cheer cheercard : cheerlist) {
			System.out.println("ID：" + cheercard.getId());
			System.out.println("USER_ID：" + cheercard.getUser_id());
			System.out.println("CUSTOMSET_ID：" + cheercard.getCustomset_id());
			System.out.println("Cheer_image:" + cheercard.getCheer_image());
			System.out.println("Cheer_message:" + cheercard.getCheer_message());
			System.out.println();
		}
	}
}
