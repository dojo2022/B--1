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
<!-- <div class="gnavi__wrap"style="z-index:10000/*前面に出す*/">
    <ul class="gnavi__lists">
        <li class="gnavi__list">
        	<a href="#">メニュータイトル</a>
        	<ul class="dropdown__lists" style="z-index:10000">
        		<li class="dropdown__list"><a href="#">メニュー1</a></li>
                <li class="dropdown__list"><a href="#">メニュー1</a></li>
                <li class="dropdown__list"><a href="#">メニュー1</a></li>
        	</ul>
    </ul>
</div>
 -->

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
</body>
</html>