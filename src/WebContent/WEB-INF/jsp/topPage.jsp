<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Forza｜TopPage</title>
	<link rel = "stylesheet" type = "text/css" href = "/Forza/css/top.css">
	<script src="/Forza/js/jquery-3.2.1.min.js"></script>
	<script src="/Forza/js/TopMyPage.js"></script>
</head>
<body>
<div class="wrapper">
<!-- ヘッダ－ -->
		<header class="header">
            <div class="logo">
                <img src="/Forza/images/Forza_trans.png" alt="home">
            </div>
            <div class="news">
                <h3>お知らせはここに表示</h3>
            </div>
            <div class="myPage">
                <input type="button" class="btn" id="displayChangeButton" value="myPage" onclick="displayChange();"><br>
				<div id="displayPanel" style="width:150px;height:200px;text-align: center;background-color:#ff0000;display:none;" >
    				表示したいDIV。中に他のオブジェクトを入れることもできる。<br>
			    <ul>
					<li onclick="location.href='/Forza/PersonalOptionServlet'">個人設定</li>
					<li onclick="location.href='/Forza/TrophyServlet'">トロフィー</li>
					<li onclick="location.href='/Forza/LogoutServlet'">ログアウト</li>
				</ul>
			    </div>
            </div>
		</header>
<!-- メイン -->
	<main class="main">
        <div class="calendar">
            <iframe src="https://calendar.google.com/calendar/embed?height=300&wkst=2&bgcolor=%23ffffff&ctz=Asia%2FTokyo&showDate=1&showPrint=0&showNav=1&showTabs=0&showCalendars=1&showTz=0&mode=MONTH&showTitle=1&src=bjI0OGhrYzNubHZwMzkwaXI5bWFvMnYzMzRAZ3JvdXAuY2FsZW5kYXIuZ29vZ2xlLmNvbQ&src=YWRkcmVzc2Jvb2sjY29udGFjdHNAZ3JvdXAudi5jYWxlbmRhci5nb29nbGUuY29t&src=amEuamFwYW5lc2Uub2ZmaWNpYWwjaG9saWRheUBncm91cC52LmNhbGVuZGFyLmdvb2dsZS5jb20&color=%23D81B60&color=%2333B679&color=%230B8043" style="border-width:0" width="290" height="300" frameborder="0" scrolling="no"></iframe>
        </div>
        <div class="task">
            タスクリスト
        </div>

        <div class="memo">
        <c:forEach var="e" items="${cardList}" >
			<form id ="topMemoForm" method="POST" action="/Forza/TopServlet">
				<table>
					<tr><td><label for="topMemo">Memo</label></td><td align="right"><input type="submit" name="submit" class="submit" value="更新"></td></tr>
					<tr><td colspan =2><textarea id="topMemo" name="top_memo" rows="25" cols="40" maxlength="200" placeholder="自由に入力（200字まで・改行は1字扱い）">${e.top_memo}</textarea></td></tr>
					<!--  テキストエリアのrowsとcolsは適宜変えてください。入力字数の制限の明示はプレイスホルダーでいいのかな？(1文字でも入力されていると表示されなくなる) -->
				</table>

			</form>
		</c:forEach>

        </div>

        <div class="trophy">
        	<table align="center">
        	  <tr>
        	  	<td align="center" class="midashi">ログイン日数:</td>
        	  	<td align="center" class="sousuu" id=topLoginC>${loginCount}</td>
        	  </tr>
        	  <tr>
        	  	<td align="center" class="midashi">タスク達成数:</td>
        	  	<td align="center" class="sousuu" id=topTaskC>${TaskCount}</td>
        	  </tr>
        	</table>
        </div>
</main>
<!-- フッタ－ -->
	<footer>

	<a href="TrophyServlet?loginCount=${loginCount}&taskCount=${TaskCount}">torophy</a>
        <!-- 今回は無し -->
	</footer>
</div>
<script src="/Forza/js/TopPage.js"></script>
</body>
</html>