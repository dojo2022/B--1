package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.CustomSetListsDao;
import model.CustomSetLists;


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

		//画面用jsを追加
				String js = "<script type=\"text/javascript\" src=\"/Forza/js/CustomSet.js\"></script>";
				request.setAttribute("script", js);

		//画面表示時、customsetlistsとcheersテーブルの中身を表示する
		CustomSetListsDao dao = new CustomSetListsDao();
		//getAllBookList()は「customsetlistが親、cheerが子」という階層構造を保持したままデータ取得するもの。
		ArrayList<CustomSetLists> customsetlists = dao.getCustomTagList();
		//リクエストスコープに取得したclicksテーブルのデータを格納
		request.setAttribute("customsetlists", customsetlists);

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
            // セッションスコープからUSER_IDを取得し、アイコンの選択
			HttpSession session = request.getSession();
		   if(session.getAttribute("id") != null) {
//			String id = (String)session.getAttribute("memo");
			   String id ="DOJO";
				System.out.println("-----個人設定------");
				System.out.println(id);
			//BackGroundImagesDao iDao = new BackGroundImagesDao();
			//List<BackGround> background = iDao.select(new BackGround(id));
			// 検索結果をリクエストスコープに上書きして格納する


			//System.out.println(background.get(0).getBackground_image());
			//request.setAttribute("myBackGround", background.get(0).getBackground_image());
		   }


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
	/*
		// セッションスコープを破棄する
		        HttpSession session = request.getSession();
		        session.invalidate();
    */
		//idはセッションスコープから受けておる
		String name = "DOJO";

        String CustomSetName = request.getParameter("cName");

				// リクエストパラメータを取得する
		        HttpSession session = request.getSession();
				request.setCharacterEncoding("UTF-8");



				// 登録処理を行う
				CustomSetListsDao bDao = new CustomSetListsDao();
				bDao.insert(new CustomSetLists(name,CustomSetName));	// 登録成功


				ArrayList<CustomSetLists> Custom_name = new ArrayList<>();
				CustomSetLists CustomSet = new CustomSetLists(name, CustomSetName);

				            //JavaオブジェクトからJSONに変換
							   ObjectMapper mapper = new ObjectMapper();
				            String testJson = mapper.writeValueAsString(CustomSet);
				            System.out.println(testJson);
				            //JSONの出力
				            response.getWriter().write(testJson);

/*

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
*/

			}

		}

