package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CheerListsDao;
import model.Cheer;

/**
 * Servlet implementation class CheerPopupServlet
 */
@WebServlet("/CheerPopupServlet")
public class CheerPopupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

				//褒めるポップアップのページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cheer.jsp");
				dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//褒めるポップアップの画像とメッセージを選択するServlet↓
				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
					String num = request.getParameter("ID");
					int id = Integer.parseInt(num);
					String user_id = request.getParameter("USER_ID");
					String customset_id = request.getParameter("CUSTOMSET_ID");
					String cheer_image = request.getParameter("CHEER_IMAGE");
					String cheer_message = request.getParameter("CHEER_MESSAGE");

				// 検索表示を行う
				CheerListsDao cDao = new CheerListsDao();
				List<Cheer> cheerList = cDao.select(new Cheer(id,user_id,customset_id,cheer_image,cheer_message));

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("cheerList", cheerList);

				// 褒めるポップアップのページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cheerAfter.jsp");
				dispatcher.forward(request, response);

	}

}
