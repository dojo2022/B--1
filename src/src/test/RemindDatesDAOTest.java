package test;
import java.util.List;

import dao.RemindDatesDao;
import model.Remind;;

public class RemindDatesDAOTest {
	public static void main(String[] args) {
		RemindDatesDao dao = new RemindDatesDao();

		System.out.println("---------- wow()のテスト ----------");
		List<Remind> Wow = dao.wow(new Remind("MARIO"));
			for (Remind list : Wow) {
				System.out.println("USER_ID：" + list.getUser_id());
				System.out.println("REMIND_NAME：" + list.getRemind_name());
				System.out.println("REMIND_DATE：" + list.getRemind_date());
				System.out.println();
			}

			/*		System.out.println("---------- select()のテスト ----------");
					List<Remind> remindList = dao.select(new Remind("HARU"));
						for (Remind list : remindList) {
							System.out.println("USER_ID：" + list.getUser_id());
							System.out.println("REMIND_NAME：" + list.getRemind_name());
							System.out.println("REMIND_DATE：" + list.getRemind_date());
							System.out.println();
						}

					System.out.println("---------- update()のテスト ----------");
					dao.salary("HARU", "20");
					dao.birth("HARU", "08", "07");

					System.out.println("---------- select()のテスト ----------");
						List<Remind> remindList1 = dao.select(new Remind("HARU"));
						for (Remind list : remindList1) {
							System.out.println("USER_ID：" + list.getUser_id());
							System.out.println("REMIND_NAME：" + list.getRemind_name());
							System.out.println("REMIND_DATE：" + list.getRemind_date());
							System.out.println();
						}

					System.out.println("---------- choose()のテスト ----------");
					List<Remind> remindList2 = dao.choose(new Remind("HARU"));
					for (Remind remind : remindList2) {
						System.out.println("USER_ID：" + remind.getUser_id());
						System.out.println("REMIND_NAME：" + remind.getRemind_name());
						System.out.println("REMIND_DATE：" + remind.getRemind_date());
						System.out.println();
					}

					System.out.println("---------- change()のテスト ----------");
					for (Remind list : remindList2) {
						dao.change(list);
					}
					System.out.println("---------- choose()のテスト ----------");
					List<Remind> remindList3 = dao.choose(new Remind("HARU"));
					for (Remind remind : remindList3) {
						System.out.println("USER_ID：" + remind.getUser_id());
						System.out.println("REMIND_NAME：" + remind.getRemind_name());
						System.out.println("REMIND_DATE：" + remind.getRemind_date());
						System.out.println();
					}
			*/
	}
}