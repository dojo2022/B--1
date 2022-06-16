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

import dao.CheerListsDao;
import model.Cheer;

/**
 * Servlet implementation class CheerServlet
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
			response.sendRedirect("/Forza/LoginServlet");
			return;
		}
		 */


		// 一覧表示を行う
		CheerListsDao cDao = new CheerListsDao();
		List<Cheer> cheerlist = cDao.show(null);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cheerlist", cheerlist);

		//褒めるポップアップのページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cheer.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		/*
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(request.getParameter("ID"));
			String user_id = request.getParameter("USER_ID");
			String customset_id = request.getParameter("CUSTOMSET_ID");
			String cheer_image = request.getParameter("CHEER_IMAGE");
			String cheer_message = request.getParameter("CHEER_MESSAGE");
		*/

		// 一覧表示を行う
		CheerListsDao cDao = new CheerListsDao();
		List<Cheer> cheerlist = cDao.show(null);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cheerlist", cheerlist);

		// 褒めるポップアップのページにフォワードする
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/jsp/cheer.jsp");
		dispatcher1.forward(request, response);
	}
}



