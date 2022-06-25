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
	}
}