package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		        response.setContentType("application/json");
				response.setHeader("Cache-Control", "nocache");
				response.setCharacterEncoding("utf-8");


				String id = request.getParameter("Id");
				String user_id = request.getParameter("User_id");
				String task_id = request.getParameter("Task_id");
				//Integer.parseInt("task_id");
				String customset_id = request.getParameter("Customset_id");
				String task_name = request.getParameter("Task_name");
				String task_memo = request.getParameter("Task_memo");
				String task_date = request.getParameter("Task_date");
				String priority = request.getParameter("Priority");
				String task_judge = request.getParameter("Task_judge");

				ArrayList<Task> taskLists = new ArrayList<>();

				// 登録処理を行う
				if(taskLists!= null) {
				TaskListsDao LDAO = new TaskListsDao();
				LDAO.insert(new Task(id,user_id,task_id,customset_id,task_name,task_memo,task_date,priority,task_judge)); 	// 登録成功
				Task task_data = LDAO.select(new Task(id,user_id,task_id,customset_id,task_name,task_memo,task_date,priority,task_judge));
				taskLists.add(task_data);
	}

				/*request.setAttribute("result",
					new Result("登録成功！", "レコードを登録しました。", "/Forza/TaskServlet"));*/
					// 登録失敗
					/*request.setAttribute("result",
					new Result("登録失敗！", "レコードを登録できませんでした。", "/Forza/TaskServlet"));
*/
				try {
					//JavaオブジェクトからJSONに変換
					//JSONの出力
					if(taskLists != null) {
						ObjectMapper mapper = new ObjectMapper();
						String json = mapper.writeValueAsString(taskLists);
					    response.getWriter().write(json);
					}
					} catch (JsonProcessingException e) {
					    e.printStackTrace();
					}

				// 結果ページにフォワードする
				response.setContentType("application/json");
				response.setHeader("Cache-Control", "nocache");
				response.setCharacterEncoding("utf-8");


	}
}
