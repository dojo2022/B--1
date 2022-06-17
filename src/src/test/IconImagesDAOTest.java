package test;
import java.util.List;

import dao.IconImagesDao;
import model.Icon;;

public class IconImagesDAOTest {
	public static void main(String[] args) {
		IconImagesDao dao = new IconImagesDao();

		System.out.println("---------- Insertのテスト ----------");
		dao.insert(new Icon("DOJO", "Forza.png"));

		System.out.println("---------- Selectのテスト ----------");
		List<Icon> NewIcon = dao.select(new Icon("DOJO"));
		for (Icon newIcon : NewIcon) {
			System.out.println("USER_ID:" + newIcon.getUser_id());
			System.out.println("ICON_IMAGE:" + newIcon.getIcon_image());
		}
	}
}