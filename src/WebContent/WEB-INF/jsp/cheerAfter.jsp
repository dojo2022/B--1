<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>褒めるポップアップ</title>
<!-- 自作のCSS読み込み↓ -->
<link rel="stylesheet" href="css/cheer_popup.css">
<!-- 閉じるボタンを押したら紙吹雪が出るようにするJS読み込み↓ -->
<script src="https://cdn.jsdelivr.net/npm/party-js@latest/bundle/party.min.js"></script>
</head>

<body>
	<!-- チェックのついたチェックボックス -->
    <input type="checkbox" name="checkbox" checked>

        <div id="popWin">
        	<!-- ポップアップウィンドウ -->
            <div class="pop-win">
            		<!-- 紙吹雪のためのdiv -->
            		<div id="particles-js"></div>
					<div id="wrapper">
	            		<h2>タスク完了！</h2>
				        <!-- カスタムセットの画像を表示 -->
				        <c:forEach var="e" items="${cheerList}">
				    		<img class="cheer_image" src="${e.cheer_image}"></img>
				    	</c:forEach>
						<br>
				    	<!-- カスタムセットのメッセージ表示 -->
				    	<c:forEach var="e" items="${cheerList}">
				    		<h2>${e.cheer_message}</h2>
				    	</c:forEach>
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
