package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
		response.setHeader("Cache-Control", "nocache");
		response.setCharacterEncoding("utf-8");
		String id = "DOJO";
		//String id = (String)session.getAttribute("memo");
		// 送信されたデータの取得
		String data1 = request.getParameter("data1");

		//ArrayListをインスタンス化
		ArrayList<Cheer> list = new ArrayList<>();

		//適当な値を突っ込む
			CheerListsDao cheer = new CheerListsDao();
			Cheer jub = cheer.one(new Cheer(id,data1));
			//jub.setCustomset_id(data1);
			list.add(jub);

		ObjectMapper mapper = new ObjectMapper();
		try {
            //JavaオブジェクトからJSONに変換
            String testJson = mapper.writeValueAsString(list);
            //JSONの出力
            response.getWriter().write(testJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

		/*//褒めるポップアップの画像とメッセージを選択するServlet↓
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
*/
	}
}