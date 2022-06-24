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
	<script type="text/javascript" src="/Forza/js/PersonalOption.js"></script>
</head>
<body>
<div class="wrapper">
<!-- ヘッダ－ -->
<header id="header">
	<div class="header_logo">
    <h1 style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;"><a href="/Forza/TopServlet">Forza</a></h1>
	</div>
    <div class="newsWrapper">
        <div class="news">
            <ul>
				<li>お知らせ：</li>
				<c:forEach var="n" items="${news}">
					<li>${n.remind_name}は${n.remind_date}です。</li>
				</c:forEach>
				<c:forEach var="h" items="${holiday}">
					<li>${h.dayOfWeek}は休日です。</li>
				</c:forEach>
                </ul>
            </div>
           </div>
    <nav style="margin-left: 0px; z-index:1; background-color:white;">
    <ul style="height: 50px;padding-left: 0px;margin-bottom: 0px;margin-top: 0px;">
      <li class="has-child"><a href="#" style="height: 50px;padding-bottom: 0px;padding-top: 0px;padding-left: 0px;padding-right: 0px;" class="menu"><img class="icon_image" src="${iconImage.icon_image}"></img></a>
        <ul>
        <li><a href="/Forza/PersonalOptionServlet">一般設定</a></li>
        <li><a href="/Forza/CustomSetServlet">カスタマイズ</a></li>
        <li><a href="/Forza/TrophyServlet?loginCount=${loginCount}&taskCount=${TaskCount}">実績</a></li>
        <li><a href="/Forza/LogoutServlet">ログアウト</a></li>
        </ul>
      </li>
    </ul>
  </nav>

  </header>
<!-- メイン -->
    <main>
    <div class = "flex">
    <div class= "left">
    	<br><b id="center">現在のアイコン画像</b><br><br><br>
        <div class="icon" style="width:100px; height:100px;">
			<img class="icon_image" alt="icon" src="${iconImage.icon_image}" style="width:100px; height:100px;">
        </div>
       <!--  <hr style="border:none;border-top:dashed 1px black;height:1px;width:95%;"><br> -->
       <div class="triangle3"></div><br>

        <div class="setting">
            <form action="/Forza/PersonalOptionServlet" method="post" enctype="multipart/form-data">
                <div class="setIcon">

                </div>

                    <label><b>新しいアイコン画像</b></label><br><br>
					<input type="file" name="IMAGE" id="img" accept="image/*" onchange="previewImage(this);"><br><br><br>
					<canvas id="preview" style="width:47px; height:47px;"></canvas><br><br>

				<div>
					<br>
					<table align="center"><tr><td align="center"><input type="button" class="button" value="変更" onclick="newIcon()"></td></tr></table>



                </div>
			</form>
</div>
</div>

<!-- ここで分ける -->

<div class="right"><br><br><br>
			<form action="/Forza/PersonalOptionServlet" method="post">
                <div class="setPw">
                    <label for="setPw"><b>変更後パスワード:</b>
                        <input type="text" id="pw" name="password" placeholder="password">
                    </label>
                </div>
                <br><br> <br><br>
                 <div class="setRemind">
                    <b>ご褒美Day(リマインダー)</b>
                    <br>
                    <br>

                        <div class="holiday">
                            &emsp;<b>休日：</b>
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
<br>
                        </div><br>
                        <div class="salary">
                        <br>
                            <label >&emsp;<b>給与日：</b>毎月
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

                                </select> 日
                            </label>
                        </div><br>
                        <div class="birthday">
                            <label>&emsp;<b>誕生日：</b>
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
                                </select> 日
                            </label>
                        </div>
                        <br>
                </div>
                <div>
                    <table align="center"><tr><td align="center"><input type="button" value="更新" id="submit" onclick="update()"></td></tr></table>
                </div>
            </form>

      </div>
</div>

    </main>
    </div>
<!-- フッタ－ -->
	<footer>
        <!-- 今回は無し -->
	</footer>

</body>
</html>