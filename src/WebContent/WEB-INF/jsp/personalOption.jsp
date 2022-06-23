<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Forza｜Setting</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<link rel = "stylesheet" type = "text/css" href = "/Forza/css/mypage_1.css">
</head>
<body>
<div class="wrapper">
<!-- ヘッダ－ -->
		<header class="header">
            <div class="logo">
                <a href="/Forza/TopServlet"><img src="/Forza/images/Forza_trans.png" alt="home"></a>
            </div>
            <div class="news">
                <h3>お知らせはここに表示</h3>
            </div>
            <div class="myPage">
                <input type="button" id="btn" value="myPage">
            </div>
		</header>
<!-- メイン -->
    <main>
        <div class="icon">
			<img class="icon_img" id="iconImage" alt="icon" src="${myIcon}">
        </div>
        <div class="setting">
            <form action="/Forza/PersonalOptionServlet" method="post" enctype="multipart/form-data">
                <div class="setIcon">
                    <label>アイコンの画像設定</label>
					<input type="file" name="IMAGE" id="img" accept="image/*" onchange="previewImage(this);"><br>
					<canvas id="preview" style="max-width:200px ;"></canvas><br>
                </div>
				<div>
					<table align="center"><tr><td align="center"><input type="button" class="button" value="変更" onclick="newIcon()"></td></tr></table>
                </div>
			</form>
<hr style="border:none;border-top:dashed 1px black;height:1px;width:450px;">
			<form action="/Forza/PersonalOptionServlet" method="post">
                <div class="setPw">
                    <label for="setPw">変更後パスワード:
                        <input type="text" id="pw" name="password" placeholder="password">
                    </label>
                </div>
                 <div class="setRemind">
                    ご褒美Day(リマインダー)
                    <br>
                    <br>
                        <div class="salary">
                            <label >&emsp;給与日：毎月
                                <select name="salary_day" id="salaryDay">
                                    <option value="">-</option>
                                    <option value="01">1</option>
                                    <option value="02">2</option>
                                    <option value="03">3</option>
                                    <option value="04">4</option>
                                    <option value="05">5</option>
                                    <option value="06">6</option>
                                    <option value="07">7</option>
                                    <option value="08">8</option>
                                    <option value="09">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                    <option value="24">24</option>
                                    <option value="25">25</option>
                                    <option value="26">26</option>
                                    <option value="27">27</option>
                                    <option value="28">28</option>
                                    <option value="29">29</option>
                                    <option value="30">30</option>
                                    <option value="31">31</option>

                                </select> 日
                            </label>
                        </div>
                        <div class="holiday">
                            &emsp;休日：
                                <div class="dayOfWeek">
                                    <input type="checkbox" id="monday" name="days" value="月曜日">
                                    <label for="monday">月</label>
                                </div>
                                <div class="dayOfWeek">
                                    <input type="checkbox" id="tuesday" name="days" value="火曜日">
                                    <label for="tuesday">火</label>
                                </div>
                                <div class="dayOfWeek">
                                    <input type="checkbox" id="wednesday" name="days" value="水曜日">
                                    <label for="wednesday">水</label>
                                </div>
                                <div class="dayOfWeek">
                                    <input type="checkbox" id="thursday" name="days" value="木曜日">
                                    <label for="thursday">木</label>
                                </div>
                                <div class="dayOfWeek">
                                    <input type="checkbox" id="friday" name="days" value="金曜日">
                                    <label for="friday">金</label>
                                </div>
                                <div class="dayOfWeek">
                                    <input type="checkbox" id="saturday" name="days" value="土曜日">
                                    <label for="saturday">土</label>
                                </div>
                                <div class="dayOfWeek">
                                    <input type="checkbox" id="sunday" name="days" value="日曜日">
                                    <label for="sunday">日</label>
                                </div>

                        </div>
                        <div class="birthday">
                            <label>&emsp;誕生日：
                                <select name="birth_month" id="birthMonth">
                                    <option value=null>-</option>
                                    <option value="01">1</option>
                                    <option value="02">2</option>
                                    <option value="03">3</option>
                                    <option value="04">4</option>
                                    <option value="05">5</option>
                                    <option value="06">6</option>
                                    <option value="07">7</option>
                                    <option value="08">8</option>
                                    <option value="09">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select> 月
                                <select name="birth_day" id="birthDay">
                                    <option value=null>-</option>
                                    <option value="01">1</option>
                                    <option value="02">2</option>
                                    <option value="03">3</option>
                                    <option value="04">4</option>
                                    <option value="05">5</option>
                                    <option value="06">6</option>
                                    <option value="07">7</option>
                                    <option value="08">8</option>
                                    <option value="09">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                    <option value="24">24</option>
                                    <option value="25">25</option>
                                    <option value="26">26</option>
                                    <option value="27">27</option>
                                    <option value="28">28</option>
                                    <option value="29">29</option>
                                    <option value="30">30</option>
                                    <option value="31">31</option>
                                </select> 日
                            </label>
                        </div>
                </div>
                <div>
                    <table align="center"><tr><td align="center"><input type="button" value="更新" id="submit" onclick="update()"></td></tr></table>
                </div>
            </form>
        </div>
    </main>
<!-- フッタ－ -->
	<footer>
        <!-- 今回は無し -->
	</footer>
</div>
<script type="text/javascript" src="/Forza/js/PersonalOption.js"></script>
</body>
</html>