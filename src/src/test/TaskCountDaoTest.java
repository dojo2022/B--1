package test;

import dao.TaskCountDao;
import model.Task;

public class TaskCountDaoTest {
	public static void main(String[] args) {
		TaskCountDao dao = new TaskCountDao();

		// show()のテスト

		System.out.println("---------- show()のテスト ----------");
		int number = dao.TaskCount(new Task("DOJO"));
			System.out.println(number);
		}
	}

