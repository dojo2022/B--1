package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CheerListsDao;
import model.Cheer;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/CheerServlet")
public class CheerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする

		HttpSession session = request.getSession();
		/*
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}
*/
		// 検索ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cheer.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();

		/*
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}
*/
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("ID"));
		String user_id = request.getParameter("USER_ID");
		String cheer_image = request.getParameter("CHEER_IMAGE");
		String cheer_message = request.getParameter("CHEER_MESSAGE");

		// 検索処理を行う
		CheerListsDao CDao = new CheerListsDao();
		//List<Cheer> cardList = CDao.select(new Cheer(id, user_id, cheer_image, cheer_message));

		// 検索結果をリクエストスコープに格納する
		//request.setAttribute("cardList", cardList);

		//1件だけ取ってくる
		Cheer cheer = CDao.getRandomCheer("user_id");
		request.setAttribute("cheer", cheer);


		//request.setAttribute("cheer_message", "/image/***.jpg");

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
		dispatcher.forward(request, response);
	}
}
