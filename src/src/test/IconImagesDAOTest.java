package test;
import dao.IconImagesDao;
import model.Icon;;

public class IconImagesDAOTest {
	public static void main(String[] args) {
		IconImagesDao dao = new IconImagesDao();

		System.out.println("---------- Insertのテスト ----------");
		dao.insert(new Icon("DOJO", "Forza.png"));

		System.out.println("---------- Selectのテスト ----------");
		Icon NewIcon = dao.select(new Icon("DOJO"));
			System.out.println("USER_ID:" + NewIcon.getUser_id());
			System.out.println("ICON_IMAGE:" + NewIcon.getIcon_image());
	}
}