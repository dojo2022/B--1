package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HolidayDao;
import dao.IconImagesDao;
import dao.RemindDatesDao;
import dao.TaskCountDao;
import dao.TaskListsDao;
import dao.TopMemosDao;
import dao.UsersDao;
import model.Holiday;
import model.Icon;
import model.LoginCount;
import model.Memo;
import model.Remind;
import model.Task;
import model.Users;

/**
 * Servlet implementation class TopServlet
 */
@WebServlet("/TopServlet")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/Forza/LoginServlet");
				return;
			}

		// お知らせの獲得

		// スコープでカウント数の取得
			request.setCharacterEncoding("UTF-8");
			String memo_id = (String)session.getAttribute("memo");
			System.out.println(memo_id);
			TaskCountDao count2 = new TaskCountDao();
			int count3 = count2.TaskCount(new Task(memo_id));
			java.lang.String[] torophy = new java.lang.String[2];
			UsersDao count = new UsersDao();
			LoginCount count1 = count.LoginCount(new Users(memo_id));

			torophy[0] = Integer.toString(count1.getCount());
			torophy[1] = Integer.toString(count3);


		// メモの検索処理を行う
			TopMemosDao mDao = new TopMemosDao();
			List<Memo> cardList = mDao.select(memo_id);

		// 近頃のご褒美Dayの検索
			RemindDatesDao news = new RemindDatesDao();
			List<Remind> newsList = news.wow(new Remind(memo_id));
			HolidayDao holiday = new HolidayDao();
			List<Holiday> hList = holiday.niceFight(memo_id);

		// 検索結果をリクエストスコープに格納する
			session.setAttribute("cardList", cardList);
			session.setAttribute("TaskCount", count3);
			session.setAttribute("torophy", torophy);
			session.setAttribute("news", newsList);
				session.setAttribute("holiday", hList);

		// アイコン画像の取得
			IconImagesDao topIcon = new IconImagesDao();
			Icon icon = topIcon.select(new Icon(memo_id));

			session.setAttribute("iconImage", icon);

		// タスクの検索処理を行う(デフォルト)
			TaskListsDao TaskDao = new TaskListsDao();
			List<Task> list = TaskDao.show();

		// 検索結果をリクエストスコープに格納する
			request.setAttribute("lists", list);

		// パラメータが渡された場合のタスク表示
			if(request.getParameter("date") != null) {
				String date =request.getParameter("date");
				List<Task> tList = TaskDao.one_day(memo_id, date);
				request.setAttribute("lists", tList);
			}

		// トップページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/topPage.jsp");
		dispatcher.forward(request, response);

	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*トップメモ関連ここから*/

		// リクエストパラメータを取得する
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		String top_memo = request.getParameter("top_memo");
		String memo_id = (String)session.getAttribute("memo");



		// 更新を行う
		TopMemosDao Dao = new TopMemosDao();
		Memo m= new Memo(memo_id,top_memo);
		if (request.getParameter("submit").equals("更新")) {

			Dao.update(m);// 更新成功

		// 検索処理を行う
			TopMemosDao mDao = new TopMemosDao();
			List<Memo> cardList = mDao.select(memo_id);

		// 検索結果をリクエストスコープに格納する
			request.setAttribute("cardList", cardList);
		/*トップページにフォワードする*/
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/topPage.jsp");
			dispatcher.forward(request, response);
		}

		/*トップメモ関連ここまで*/

		/* タスクリストの表示変更など */

	}

}
