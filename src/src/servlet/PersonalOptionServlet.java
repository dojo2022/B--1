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
import javax.servlet.http.Part;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.HolidayDao;
import dao.IconImagesDao;
import dao.RemindDatesDao;
import dao.UsersDao;
import model.Holiday;
import model.Icon;

@MultipartConfig(location = "C:\\dojo6\\src\\WebContent\\icon_images") // アップロードファイルの一時的な保存先
@WebServlet("/PersonalOptionServlet")
public class PersonalOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PersonalOptionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();

		if (session.getAttribute("id") == null) {
			response.sendRedirect("/Forza/LoginServlet");
			return;
		}

		request.setCharacterEncoding("UTF-8");

		// デフォルトのアイコンのデータをスコープに格納
		Icon sample = new Icon("","/Forza/icon_images/icon_test_1.png");
		request.setAttribute("myIcon", sample);

		// セッションスコープからUSER_IDを取得し、アイコンの選択
		if(session.getAttribute("id") != null) {
			String id = (String)session.getAttribute("memo");  // IDを取得
			IconImagesDao iDao = new IconImagesDao();
			Icon icon = iDao.select(new Icon(id));
			String iconImage = icon.getIcon_image();
			// 検索結果をリクエストスコープに上書きして格納する
			System.out.println(icon);
			request.setAttribute("myIcon", iconImage);
		}

		// 個人設定ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/personalOption.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memo");

		request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
		response.setHeader("Cache-Control", "nocache");
		response.setCharacterEncoding("utf-8");

		// 送信されたデータの取得
		String pw = request.getParameter("Pw");
		String icon = request.getParameter("Icon");
		String salary = request.getParameter("Salary");
		String sun = request.getParameter("Sun");
		String mon = request.getParameter("Mon");
		String tue = request.getParameter("Tue");
		String wed = request.getParameter("Wed");
		String thu = request.getParameter("Thu");
		String fri = request.getParameter("Fri");
		String sat = request.getParameter("Sat");
		String birthMonth = request.getParameter("BirthMonth");
		String birthDay = request.getParameter("BirthDay");

		// 画像の保存等
		Part part = request.getPart("IMAGE"); // getPartで取得

		String image = this.getFileName(part);
		request.setAttribute("image", image);
		// サーバの指定のファイルパスへファイルを保存
        //場所はクラス名↑の上に指定してある
		part.write(image);

		ArrayList<Icon> iconImage = new ArrayList<>();

		// アイコンの保存
		if(image != null) {
		IconImagesDao newicon = new IconImagesDao();
		newicon.insert(new Icon(id,image));
		Icon icon_data = newicon.select(new Icon(id));
		iconImage.add(icon_data);
		}

		// PWの変更
		if (pw != null) {
		UsersDao user = new UsersDao();
		user.isChangePw(pw);
		}

		// 給料日設定
		if(salary != null) {
			RemindDatesDao cSalary = new RemindDatesDao();
			cSalary.salary(id, salary);
		}

		// 月日どっちも入っていたら誕生日設定
		if(birthMonth != null && birthDay != null) {
			RemindDatesDao birth = new RemindDatesDao();
			birth.birth(id, birthMonth, birthDay);
		}

		// 休日の設定
		HolidayDao holiday = new HolidayDao();

		if(sun != null) {
			holiday.fight(new Holiday(id, sun, true));
		}
		if(mon != null) {
			holiday.fight(new Holiday(id, mon, true));
		}
		if(tue != null) {
			holiday.fight(new Holiday(id, tue, true));
		}
		if(wed != null) {
			holiday.fight(new Holiday(id, wed, true));
		}
		if(thu != null) {
			holiday.fight(new Holiday(id, thu, true));
		}
		if(fri != null) {
			holiday.fight(new Holiday(id, fri, true));
		}
		if(sat != null) {
			holiday.fight(new Holiday(id, sat, true));
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


	//ファイルの名前を取得してくる
	private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
	}

}
