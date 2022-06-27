<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>実績画面</title>
<link rel = "stylesheet" type = "text/css" href = "/Forza/css/Trophy.css">
<script  src="/Forza/js/Trophy.js"></script>
</head>
<body>

<!-- ヘッダーやフッターはトップページのものが完成次第コピペしてくる -->

<!-- ヘッダ－ -->
<header id="header">
	<div class="header_logo">
    <h1 style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;"><a href="/Forza/TopServlet">Forza</a></h1>
	</div>
    <div class="newsWrapper">
        <div class="news">
            <br class="newsBr">
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
      <li class="has-child">
	      <a href="#" style="height: 50px;padding-bottom: 0px;padding-top: 0px;padding-left: 0px;padding-right: 0px;" class="menu">
	      <img class="icon_image" src="${iconImage.icon_image}"></img>
	      <img class="menu_image" src="/Forza/images/menu47-1.png">
	      </a>
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

<main>


		<div class="background">
			<img class="backgound_img" alt="background" src="${background}">
		</div>



<div class="TrophyDiv">

<h1 align="center">Congratulations!</h1>



<table align="center">

	<tr>
		<td align="center" class="midashi">ログイン日数</td>
		<td align="center"><img id="login1"   src="images/cup.png" width=90;></td>
		<td align="center"><img id="login7"   src="images/none.png" width=90;></td>
		<td align="center"><img id="login30"  src="images/none.png" width=90;></td>
		<td align="center"><img id="login60"  src="images/none.png" width=90;></td>
		<td align="center"><img id="login100" src="images/none.png" width=90;></td>
		<td align="center"><img id="login180" src="images/none.png" width=90;></td>
		<td align="center"><img id="login365" src="images/none.png" width=90;></td>
		<td align="center"><img id="login555" src="images/none.png" width=90;></td>
		<td align="center"><img id="login777" src="images/none.png" width=90;></td>
		<td align="center"><img id="login1000"src="images/none.png" width=90;></td>
	</tr>
	<tr>
		<td align="center" class="sousuu" id=loginC></td>
		<td align="center" class="a">1</td>
		<td align="center" id= "login7n">7</td>
		<td align="center" id= "login30n">30</td>
		<td align="center" id= "login60n">60</td>
		<td align="center" id= "login100n">100</td>
		<td align="center" id= "login180n">180</td>
		<td align="center" id= "login365n">365</td>
		<td align="center" id= "login555n">555</td>
		<td align="center" id= "login777n">777</td>
		<td align="center" id= "login1000n">1000</td>
	</tr>

	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>


	<tr>
		<td align="center" class="midashi">タスク達成数</td>
		<td><img id="task1"   src="images/none.png" width=90;></td>
		<td><img id="task7"   src="images/none.png" width=90;></td>
		<td><img id="task30"  src="images/none.png" width=90;></td>
		<td><img id="task60"  src="images/none.png" width=90;></td>
		<td><img id="task100" src="images/none.png" width=90;></td>
		<td><img id="task180" src="images/none.png" width=90;></td>
		<td><img id="task365" src="images/none.png" width=90;></td>
		<td><img id="task555" src="images/none.png" width=90;></td>
		<td><img id="task777" src="images/none.png" width=90;></td>
		<td><img id="task1000"src="images/none.png" width=90;></td>
	</tr>
	<tr>
		<td align="center"class="sousuu" id="taskC"></td>
		<td align="center" id="task1n">1</td>
		<td align="center" id="task7n">7</td>
		<td align="center" id="task30n">30</td>
		<td align="center" id="task60n">60</td>
		<td align="center" id="task100n">100</td>
		<td align="center" id="task180n">180</td>
		<td align="center" id="task365n">365</td>
		<td align="center" id="task555n">555</td>
		<td align="center" id="task777n">777</td>
		<td align="center" id="task1000n">1000</td>
	</tr>

	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>


</table>

</div>
</main>
</body>
</html>