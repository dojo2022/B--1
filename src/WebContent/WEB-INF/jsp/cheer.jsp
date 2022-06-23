<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>褒めるポップアップ</title>
<link rel="stylesheet" href="css/cheer_popup.css">
 <script src="https://cdn.jsdelivr.net/npm/party-js@latest/bundle/party.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
 -->
</head>

<body>
    <!-- <form class="checkbox_form" method="POST" action="/Forza/CheerPopupServlet"> -->
    	<input type="hidden" name="ID" value="1">
        <input type="checkbox" name="CUSTOMSET_ID" value="1" onchange="checkedBox()" id="chk_box" checked>
        <!-- <input type="submit" name="REGIST" value="表示"> -->
        <input type="button" value="確定" onclick="goAjax()">
    <!-- </form> -->

         <div id="popWin">
         <!-- 紙吹雪のためのdiv -->
            		<div id="particles-js"></div>
					<div id="wrapper">
        	<!-- ポップアップウィンドウ -->
            <div class="popwin-inside">
	            		<h2>タスク完了！</h2>
				        <!-- カスタムセットの画像を表示 -->
				        <div id="cheerImage"></div>
						        <%-- <c:forEach var="e" items="${cheerList}">
						    		<img class="cheer_image" src="${e.cheer_image}"></img>
						    	</c:forEach> --%>
						<br>
				    	<!-- カスタムセットのメッセージ表示 -->
				    	<h3><div id="cheerMessage"></div></h3>
						    	<%-- <c:forEach var="e" items="${cheerList}">
						    		<h2>${e.cheer_message}</h2>
						    	</c:forEach> --%>
				    	 <br>
				    	 <!-- 閉じるボタン -->
	                	<div id="close" onmousedown="party.confetti(this)">閉じる</div>
            		</div>
        	</div>
		</div>

<!-- 全面紙吹雪のjsダウンロード -->
	<script src="http://cdn.jsdelivr.net/particles.js/2.0.0/particles.min.js"></script>
<!-- 自作のjs読み込み-->
	<script src="js/CheerPopup.js" defer></script>
</body>
</html>
