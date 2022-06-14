package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*リクエストパラメータを取得してくる元のDAOをインポートする*/

/**
 * Servlet implementation class TrophyServlet
 */
@WebServlet("/TrophyServlet")
public class TrophyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrophyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// トロフィーページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Trophy.jsp");
		dispatcher.forward(request, response);


		/*		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				ログイン日数
				int loginCount = Integer.parseInt(request.getParameter("loginCount"));
				タスク達成数
				int taskCount =  Integer.parseInt(request.getParameter("taskCount"));

				// リクエストスコープに格納する
				request.setAttribute("loginCount", loginCount());
				request.setAttribute("taskCount", taskCount());

		*/


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
