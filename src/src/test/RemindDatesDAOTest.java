package test;
import java.util.List;

import dao.RemindDatesDao;
import model.Remind;;

public class RemindDatesDAOTest {
	public static void main(String[] args) {
		RemindDatesDao dao = new RemindDatesDao();

		System.out.println("---------- choose()のテスト ----------");
		List<Remind> remindList = dao.choose(new Remind("HARU"));
		for (Remind remind : remindList) {
			System.out.println("USER_ID：" + remind.getUser_id());
			System.out.println("REMIND_NAME：" + remind.getRemind_name());
			System.out.println("REMIND_DATE：" + remind.getRemind_date());
			System.out.println();
		}


		System.out.println("---------- update()のテスト ----------");
		for (Remind list : remindList) {
			dao.change(list);
			List<Remind> remindList2 = dao.select(list);
			for (Remind remind2 : remindList2) {
				System.out.println("USER_ID：" + remind2.getUser_id());
				System.out.println("REMIND_NAME：" + remind2.getRemind_name());
				System.out.println("REMIND_DATE：" + remind2.getRemind_date());
				System.out.println();
			}
		}
		System.out.println("---------- select()のテスト ----------");
		List<Remind> remindList2 = dao.select(new Remind("HARU"));
		for (Remind list : remindList2) {
			System.out.println("USER_ID：" + list.getUser_id());
			System.out.println("REMIND_NAME：" + list.getRemind_name());
			System.out.println("REMIND_DATE：" + list.getRemind_date());
			System.out.println();

		}
	}
}