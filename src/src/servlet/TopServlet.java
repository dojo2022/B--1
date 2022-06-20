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

import dao.TaskCountDao;
import dao.TopMemosDao;
import dao.UsersDao;
import model.LoginCount;
import model.Memo;
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
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/Forza/LoginServlet");
//			return;
//		}



				// スコープでデータの取得
						request.setCharacterEncoding("UTF-8");
						String memo_id = (String)session.getAttribute("memo");
						System.out.println(memo_id);
						UsersDao count = new UsersDao();
						LoginCount count1 = count.LoginCount(new Users(memo_id));
						request.setAttribute("loginCount",count1.getCount() );
						TaskCountDao count2 = new TaskCountDao();
						int count3 = count2.TaskCount(new Task(memo_id));
						java.lang.String[] torophy = new java.lang.String[2];
						torophy[0] = Integer.toString(count1.getCount());
						torophy[1] = Integer.toString(count3);


				// 検索処理を行う
						TopMemosDao mDao = new TopMemosDao();
						List<Memo> cardList = mDao.select(memo_id);

						// 検索結果をリクエストスコープに格納する
						request.setAttribute("cardList", cardList);
						request.setAttribute("TaskCount", count3);
						request.setAttribute("torophy", torophy);


		/*トップメモ関連ここまで*/

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
	}

}
