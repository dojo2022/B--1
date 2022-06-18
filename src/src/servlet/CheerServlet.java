package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.CheerListsDao;
import dao.IconImagesDao;
import model.Cheer;
import model.Icon;

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

		//褒めるポップアップのページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cheer.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();

		// デフォルトのアイコンのデータをスコープに格納
				List<Icon> img_sample = new ArrayList<Icon>();
				Icon sample = new Icon("","/Forza/icon_images/icon_test_1.png");
				img_sample.add(sample);
				request.setAttribute("myIcon", img_sample.get(0).getIcon_image());

				// セッションスコープからUSER_IDを取得し、アイコンの選択
				if(session.getAttribute("id") != null) {
					String id = (String)session.getAttribute("memo");
						System.out.println("-----個人設定------");
						System.out.println(id);
					IconImagesDao iDao = new IconImagesDao();
					List<Icon> icon = iDao.select(new Icon(id));
					// 検索結果をリクエストスコープに上書きして格納する
					System.out.println(icon.get(0).getIcon_image());
					request.setAttribute("myIcon", icon.get(0).getIcon_image());
				}

				// 個人設定ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/personalOption.jsp");
				dispatcher.forward(request, response);

			}

			protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				HttpSession session = request.getSession();
				String id = (String)session.getAttribute("memo");

				request.setCharacterEncoding("UTF-8");

				Part part = request.getPart("IMAGE"); // getPartで取得

				String image = this.getFileName(part);
				request.setAttribute("image", image);
				// サーバの指定のファイルパスへファイルを保存
		        //場所はクラス名↑の上に指定してある
				part.write(image);
				IconImagesDao newicon = new IconImagesDao();
				newicon.insert(new Icon(id,image));

		        //ディスパッチ
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);

		//
//				if (request.getParameter("password") != null) {
//				String password = request.getParameter("password");
//				UsersDao user = new UsersDao();
//				user.isChangePw(password);
//				}
		//
		/*
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}
		*/

		//褒めるポップアップの画像とメッセージを選択するServlet↓
		//板垣が書きました
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
			int id1 = Integer.parseInt(request.getParameter("ID"));
			String user_id = request.getParameter("USER_ID");
			String customset_id = request.getParameter("CUSTOMSET_ID");
			String cheer_image = request.getParameter("CHEER_IMAGE");
			String cheer_message = request.getParameter("CHEER_MESSAGE");

		request.setCharacterEncoding("UTF-8");

		// 検索表示を行う
		CheerListsDao cDao = new CheerListsDao();
		List<Cheer> cheerList = cDao.select(new Cheer(id1,user_id,customset_id,cheer_image,cheer_message));


		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cheerList", cheerList);

		// 褒めるポップアップのページにフォワードする
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/jsp/cheerAfter.jsp");
		dispatcher1.forward(request, response);
	}

			private String getFileName(Part part) {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}
}



