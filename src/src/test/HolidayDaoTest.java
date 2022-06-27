package test;
import java.util.List;

import dao.HolidayDao;
import model.Holiday;;

public class HolidayDaoTest {
	public static void main(String[] args) {
		HolidayDao dao = new HolidayDao();

		System.out.println("---------- chooseのテスト ----------");
		List<Holiday> chHoliday = dao.choose(new Holiday("MARIO"));
		for(Holiday h : chHoliday) {
			System.out.println(h.getHoliday() + ":" + h.getDayOfWeek());
		}

		System.out.println("---------- updateのテスト ----------");
		for(Holiday h : chHoliday) {
			boolean b = dao.update(h);
			System.out.println(b);
		}

		System.out.println("---------- settingのテスト ----------");
		dao.fight(new Holiday("MARIO", "月曜日", true));
		dao.fight(new Holiday("MARIO", "火曜日", true));
		dao.fight(new Holiday("MARIO", "水曜日", true));
		dao.fight(new Holiday("MARIO", "木曜日", true));
		dao.fight(new Holiday("MARIO", "金曜日", true));
		dao.fight(new Holiday("MARIO", "土曜日", true));
		dao.fight(new Holiday("MARIO", "日曜日", true));


	}
}