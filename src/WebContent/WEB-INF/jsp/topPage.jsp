<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Forza｜TopPage</title>
	<script src="/Forza/js/jquery-3.2.1.min.js"></script>
	<script src="/Forza/js/TopMyPage.js"></script>
</head>
<body>
<div class="wrapper">
<!-- ヘッダ－ -->
<header id="header">
    <h1 style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;"><a href="/Forza/TopServlet">Forza</a></h1>
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
    <nav style="margin-left: 0px;">
    <ul style="height: 50px;padding-left: 0px;margin-bottom: 0px;margin-top: 0px;">
      <li class="has-child"><a href="#" style="height: 50px;padding-bottom: 0px;padding-top: 0px;padding-left: 0px;padding-right: 0px;" class="menu">MENU</a>
        <ul>
        <li><a href="/Forza/PersonalOptionServlet">一般設定</a></li>
        <li><a href="/Forza/CustomSetServlet">カスタマイズ</a></li>
        <li><a href="TrophyServlet?loginCount=${loginCount}&taskCount=${TaskCount}">実績</a></li>
        <li><a href="/Forza/LogoutServlet">ログアウト</a></li>
        </ul>
      </li>
    </ul>
  </nav>

  </header>
<!-- 		<header class="header">
            <div class="logo">
                <a href="/Forza/TopServlet"><img src="/Forza/images/Forza_trans.png" alt="home"></a>
            </div>
            <div class="news">
            お知らせ：
            <c:forEach var="a" items="${news}">
				<ul>
					<li><pre>${a.remind_date}は${a.remind_name}です。&#009;</pre></li>
				</ul>
            </c:forEach>
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
 --><!-- メイン -->
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

        <a href="TrophyServlet?loginCount=${loginCount}&taskCount=${TaskCount}" class="trophy" onclick="TrophyServlet?loginCount=${loginCount}&taskCount=${TaskCount}">
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
        </a>
</main>
<!-- フッタ－ -->
	<footer>

<%-- 	<a href="TrophyServlet?loginCount=${loginCount}&taskCount=${TaskCount}">torophy</a> 上に移動したけど一応残してます--%>
        <!-- 今回は無し -->
	</footer>
</div>
	<link rel = "stylesheet" type = "text/css" href = "/Forza/css/top.css">
<script src="/Forza/js/TopPage.js"></script>
</body>
</html>