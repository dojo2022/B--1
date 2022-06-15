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
import javax.servlet.http.Part;

import dao.IconImagesDao;
import model.Icon;

/**
 * Servlet implementation class PersonalOptionServlet
 */
@MultipartConfig(location = "C:\\dojo6\\src\\WebContent\\images") // アップロードファイルの一時的な保存先
@WebServlet("/PersonalOptionServlet")
public class PersonalOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PersonalOptionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();

//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/Forza/LoginServlet");
//			return;
//		}

		request.setCharacterEncoding("UTF-8");

		// デフォルトのアイコンのデータをスコープに格納
		Icon img_sample = new Icon("", "/Forza/icon_images/icon_test_1.png");
		request.setAttribute("icon", img_sample);

		// セッションスコープからUSER_IDを取得し、アイコンの選択
		String obj = (String)session.getAttribute("memo");
			System.out.println("-----個人設定------");
			System.out.println(obj);
		IconImagesDao iDao = new IconImagesDao();
		List<Icon> icon = iDao.select(new Icon(obj));

		// 検索結果をリクエストスコープに上書きして格納する
		if(icon != null) {
		request.setAttribute("icon", icon);
		}

		// 個人設定ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/personalOption.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Part part = request.getPart("IMAGE"); // getPartで取得

		String image = this.getFileName(part);
		request.setAttribute("image", image);
		// サーバの指定のファイルパスへファイルを保存
        //場所はクラス名↑の上に指定してある
		part.write(image);
        //ディスパッチ
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
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
