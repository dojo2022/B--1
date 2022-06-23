
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
 * Servlet implementation class TaskRegistServlet
 */
@WebServlet("/TaskRegistServlet")
public class TaskRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				/*HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/simpleBC/LoginServlet");
					return;
				}*/

				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String id = request.getParameter("id");
				String user_id = request.getParameter("user_id");
				String task_id = request.getParameter("task_id");
				//Integer.parseInt("task_id");
				String customset_id = request.getParameter("customset_id");
				String task_name = request.getParameter("task_name");
				String task_memo = request.getParameter("task_memo");
				String task_date = request.getParameter("task_date");
				String priority = request.getParameter("priority");
				String task_judge = request.getParameter("task_judge");


				// 登録処理を行う
				TaskListsDao LDAO = new TaskListsDao();
				if (LDAO.insert(new Task(id,user_id,task_id,customset_id,task_name,task_memo,task_date,priority,task_judge))) {	// 登録成功
					/*request.setAttribute("result",
					new Result("登録成功！", "レコードを登録しました。", "/Forza/TaskServlet"));*/
				}
				else {												// 登録失敗
					/*request.setAttribute("result",
					new Result("登録失敗！", "レコードを登録できませんでした。", "/Forza/TaskServlet"));*/
				}
				TaskListsDao TaskDao = new TaskListsDao();
				List<Task> list = TaskDao.show();

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("lists", list);
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/taskList.jsp");
				dispatcher.forward(request, response);
	}

}
