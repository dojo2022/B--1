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

import dao.CustomSetListsDao;
import model.CustomSetLists;
import model.Result;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/CustomSetServlet")
public class CustomSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// カスタムセットのタグ
	        CustomSetListsDao CustomDao = new CustomSetListsDao();
			List<CustomSetLists> List = CustomDao.show();
        // カスタムセットの中身（CheerListsDao)




        // 検索結果をリクエストスコープに格納する
			request.setAttribute("List", List);

		// 検索ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/customSet.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする

		    // セッションスコープを破棄する
		        HttpSession session = request.getSession();
		        session.invalidate();

		    // カスタムセットにリダイレクトする
		        response.sendRedirect("/Forza/CustomSetServlet");

				// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String name = request.getParameter("name");

				// 登録処理を行う
				CustomSetListsDao bDao = new CustomSetListsDao();
				if (bDao.insert(new CustomSetLists(name))){	// 登録成功
					request.setAttribute("result",
					new Result("登録成功！", "レコードを登録しました。", "/Forza/CustomSetServlet"));
				}
				else {												// 登録失敗
					request.setAttribute("result",
					new Result("登録失敗！", "レコードを登録できませんでした。", "/Forza/CustomSetServlet"));
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/customSet.jsp");
				dispatcher.forward(request, response);
			}

		}

