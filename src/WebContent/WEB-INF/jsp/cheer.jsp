<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>褒めるポップアップ</title>
<link rel="stylesheet" href="css/cheer_popup.css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>

<body>
    <form class="checkbox_form" method="POST" action="/Forza/CheerPopupServlet">
    	<input type="hidden" name="ID" value="1">
        <input class="check" type="checkbox" name="CUSTOMSET_ID" value="1">
        <input type="submit" name="REGIST" value="表示">
    </form>

        <div id="popWin">
            <div class="pop-win">
            		<h2>画像</h2>
			        <c:forEach var="e" items="${cheerList}">
			    		<img class="cheer_image" src="${e.cheer_image}"></img>
			    	</c:forEach>
					<br>
			    	<h2>メッセージ</h2>
			    	<c:forEach var="e" items="${cheerList}">
			    		<h4>${e.cheer_message}</h4>
			    	</c:forEach>
			    	 <br>
                <div id="close"><img class="close" src="images/check.png"></div>
            </div>
        </div>

</body>
<script src="js/CheerPopup.js" defer></script>
</html>
