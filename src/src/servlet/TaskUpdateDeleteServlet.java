package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.TaskListsDao;
import model.Result;
import model.Task;


/**
 * Servlet implementation class TaskUpdateDeleteServlet
 */
@WebServlet("/TaskUpdateDeleteServlet")
public class TaskUpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		//HttpSession session = request.getSession();
		//if (session.getAttribute("id") == null) {
			//response.sendRedirect("/simpleBC/LoginServlet");
			//return;
		//}


		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
		response.setHeader("Cache-Control", "nocache");
		response.setCharacterEncoding("utf-8");
		
		
		String id = request.getParameter("id");
		String user_id = request.getParameter("user_id");
		String task_id = request.getParameter("task_id");
		String customset_id = request.getParameter("customset_id");
		String task_name = request.getParameter("task_name");
		String task_memo = request.getParameter("task_memo");
		String task_date = request.getParameter("task_date");
		String priority = request.getParameter("priority");
		String task_judge = request.getParameter("task_judge");

		/*if("true".equals(task_judge)) {

		}else {
			bool=false;
		}
		task_judge = Boolean.valueOf("task_judge");
		*/


		// 更新または削除を行う
		TaskListsDao LDAO = new TaskListsDao();
		if (request.getParameter("SUBMIT").equals("更新")) {
			if (LDAO.update(new Task(id,user_id,task_id,customset_id,task_name,task_memo,task_date,priority,task_judge))) {	// 更新成功
				request.setAttribute("result",
				new Result("更新成功！", "レコードを更新しました。", "//Forza/TaskServlet"));
			}
			else {												// 更新失敗
				request.setAttribute("result",
				new Result("更新失敗！", "レコードを更新できませんでした。", "/Forza/TaskServlet"));
			}
		}else
		if (request.getParameter("SUBMIT").equals("削除")) {
			if (LDAO.delete(id)) {	// 削除成功
				request.setAttribute("result",
				new Result("削除成功！", "レコードを削除しました。", "/Forza/TaskServlet"));
			}
			else {						// 削除失敗
				request.setAttribute("result",
				new Result("削除失敗！", "レコードを削除できませんでした。", "/Forza/TaskServlet"));
			}
		}

		try {
			//JavaオブジェクトからJSONに変換
			//JSONの出力
			if(iconImage != null) {
				ObjectMapper mapper = new ObjectMapper();
				String json = mapper.writeValueAsString(iconImage);
			    response.getWriter().write(json);
			}
			} catch (JsonProcessingException e) {
			    e.printStackTrace();
			}
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "nocache");
		response.setCharacterEncoding("utf-8");
	}

}
