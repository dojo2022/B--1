package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BackGroundImagesDao;
import dao.CustomSetListsDao;
import model.BackGround;
import model.CustomSetLists;
import model.Result;


/**
 * Servlet implementation class RegisterServlet
 */

@MultipartConfig(location = "C:\\dojo6\\src\\WebContent\\background_images") // アップロードファイルの一時的な保存先
@WebServlet("/CustomSetServlet")
public class CustomSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// カスタムセットのタグ
	        CustomSetListsDao bDao = new CustomSetListsDao();
			List<CustomSetLists> List = bDao.show();

/*
        // カスタムセットの中身（CheerListsDao)
            CheerListsDao CustomDao = new CheerListsDao();
            List<CustomSetLists> List = CustomDao.show();
*/


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

	/*
		// セッションスコープを破棄する
		        HttpSession session = request.getSession();
		        session.invalidate();
    */

				// リクエストパラメータを取得する
		        HttpSession session = request.getSession();
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


	            // セッションスコープからUSER_IDを取得し、アイコンの選択
			   if(session.getAttribute("id") != null) {
				String id = (String)session.getAttribute("memo");
					System.out.println("-----個人設定------");
					System.out.println(id);
				BackGroundImagesDao iDao = new BackGroundImagesDao();
				List<BackGround> background = iDao.select(new BackGround(id));
				// 検索結果をリクエストスコープに上書きして格納する
				System.out.println(background.get(0).getBackground_image());
				request.setAttribute("myBackGround", background.get(0).getBackground_image());
			   }

			 //ディスパッチ
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
			}

		}

