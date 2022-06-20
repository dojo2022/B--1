package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskListsDao;
import model.Task;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/TaskServlet")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/Forza/LoginServlet");
			return;
		}*/

		// 検索処理を行う
		TaskListsDao TaskDao = new TaskListsDao();
		List<Task> list = TaskDao.show();

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("lists", list);

		// テンポラリーページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/taskList.jsp");
		dispatcher.forward(request, response);



        // １：タスクリストの「task_title」がクリックされる
        // ２：一回トップ画面に戻る？
        // ３：追加編集のポップアップが表示される?
		// RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/topPage.jsp");
		// dispatcher.forward(request, response);

    }

}


