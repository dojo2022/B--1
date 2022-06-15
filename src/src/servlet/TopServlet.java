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

import dao.TopMemosDao;
import model.Memo;
/**
 * Servlet implementation class TopServlet
 */
@WebServlet("/TopServlet")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/Forza/LoginServlet");
			return;
		}






				// スコープでデータの取得
						request.setCharacterEncoding("UTF-8");
						String obj = (String)session.getAttribute("memo");
						System.out.println(obj);





				// 検索処理を行う
						TopMemosDao mDao = new TopMemosDao();
						List<Memo> cardList = mDao.select(new Memo(obj));

						// 検索結果をリクエストスコープに格納する
						request.setAttribute("cardList", cardList);


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
		String obj = (String)session.getAttribute("memo");


		// 更新を行う
		TopMemosDao Dao = new TopMemosDao();
		if (request.getParameter("submit").equals("更新")) {
			Dao.update(new Memo(obj,top_memo));// 更新成功
		/*トップページにフォワードする*/
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/topPage.jsp");
			dispatcher.forward(request, response);




		}

		/*トップメモ関連ここまで*/
	}

}
