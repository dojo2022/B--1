package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.BackGroundImagesDao;
import dao.CheerListsDao;
import dao.CustomSetListsDao;
import model.BackGround;
import model.Cheer;
import model.CustomSetLists;


/**
 * Servlet implementation class RegisterServlet
 */

@MultipartConfig(location = "C:\\dojo6\\src\\WebContent\\cheer_images") // アップロードファイルの一時的な保存先
@WebServlet("/CustomSetServlet")
public class CustomSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションスコープからUSER_IDを取得し、アイコンの選択
					HttpSession session = request.getSession();

		//画面用jsを追加
				String js = "<script type=\"text/javascript\" src=\"/Forza/js/CustomSet.js\"></script>";
				request.setAttribute("script", js);

		//画面表示時、customsetlistsとcheersテーブルの中身を表示する
		CustomSetListsDao dao = new CustomSetListsDao();

		//getAllBookList()は「customsetlistが親、cheerが子」という階層構造を保持したままデータ取得するもの。
		ArrayList<CustomSetLists> customsetlists = dao.getCustomTagList();

		//リクエストスコープに取得したclicksテーブルのデータを格納
		session.setAttribute("customsetlists", customsetlists);

/*
		// カスタムセットのタグ
	        CustomSetListsDao bDao = new CustomSetListsDao();
			List<CustomSetLists> List = bDao.show();
*/
/*
        // カスタムセットの中身（CheerListsDao)
            CheerListsDao CustomDao = new CheerListsDao();
            List<Cheer> customList = CustomDao.show();
*/


//			String id = (String)session.getAttribute("memo");
			   String id ="DOJO";
				System.out.println("-----個人設定------");
				System.out.println(id);
			BackGroundImagesDao iDao = new BackGroundImagesDao();
			List<BackGround> background = iDao.select(new BackGround(id));

			// 検索結果をリクエストスコープに上書きして格納する
			session.setAttribute("background", background.get(0).getBackground_image());



/*
        // 検索結果をリクエストスコープに格納する
			request.setAttribute("List", List);
			request.setAttribute("customList", customList);
*/
		// 検索ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/customSet.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
		response.setHeader("Cache-Control", "nocache");
		response.setCharacterEncoding("utf-8");
		HttpSession session =request.getSession();

		//idはセッションスコープから受けとる
		String name = "DOJO";

		// 背景
		if (  request.getPart("BACK") != null) { // getPartで取得
			Part part = request.getPart("BACK");
			String image = this.getFileName(part);
			session.setAttribute("background", image);
		// サーバの指定のファイルパスへファイルを保存
        //場所はクラス名↑の上に指定してある
			part.write(image);
			BackGroundImagesDao iDao = new BackGroundImagesDao();
			iDao.insert(new BackGround(name, image));
	        List<BackGround> background = iDao.select(new BackGround(name));
	        session.setAttribute("background", background.get(0).getBackground_image());
		}

		// 応援
		if(request.getParameter("CHEER") != null) {
			Part part = request.getPart("CHEER");
			String image = this.getFileName(part);
			request.setAttribute("cheer_image", image);
			// サーバの指定のファイルパスへファイルを保存
	        //場所はクラス名↑の上に指定してある
			part.write(image);
			String message = request.getParameter("ADDMESSAGE");
			CheerListsDao cDao = new CheerListsDao();
			cDao.touroku(new Cheer(name, image, message));
		}

		if(request.getParameter("ADDTEXT") != null) {
			CustomSetListsDao bDao = new CustomSetListsDao();
			String cName = request.getParameter("ADDTEXT");
			bDao.insert(new CustomSetLists(name,cName));	// 登録成功

		}
	/*
		// セッションスコープを破棄する
		        HttpSession session = request.getSession();
		        session.invalidate();
    */


		// リクエストパラメータを取得する

		// セッションスコープからUSER_IDを取得し、アイコンの選択


		// 登録処理を行う


		// メニューサーブレットにリダイレクトする
		response.sendRedirect("/Forza/CustomSetServlet");


		//JavaオブジェクトからJSONに変換
		//   ObjectMapper mapper = new ObjectMapper();
		// String testJson = mapper.writeValueAsString(CustomSet);
        //System.out.println(testJson);
        //JSONの出力
        //response.getWriter().write(testJson);

	   /*
					if(session.getAttribute("id") != null) {
		String id = (String)session.getAttribute("memo");
			System.out.println("-----個人設定------");
			System.out.println(id);

	   }
		*/

					}
		//ファイルの名前を取得してくる
		private String getFileName(Part part) {
	        String name = null;
	        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
	            if (dispotion.trim().startsWith("filename")) {
	                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
	                name = name.substring(name.lastIndexOf("\\") + 1);
	                break;
	            }
	        }		// TODO 自動生成されたメソッド・スタブ
			return name;
		}
	}