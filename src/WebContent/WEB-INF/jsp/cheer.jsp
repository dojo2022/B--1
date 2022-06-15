<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>褒めるポップアップ</title>
<link rel="stylesheet" href="css/cheer_popup.css">
</head>

<body>
    <input type="checkbox" name="checkbox">
        <div id="popWin">
            <div class="pop-win">
            	<table id ="cheerlist">
            		<tr>
            			<th>ID｜</th><th>ユーザーID｜</th><th>カスタムセットID｜</th><th>画像｜</th><th>メッセージ</th>
            		</tr>
			        <c:forEach var="e" items="${cheerlist}">
			    		<tr class="data_row2"><td>${e.id}</td><td>${e.user_id}</td><td>${e.customset_id}</td><td>${e.cheer_image}</td><td>${e.cheer_message}</td></tr>
			    	</c:forEach>
			    </table>
                <div id="close"><img src="images/check.png"></div>
            </div>
        </div>
</body>
<script src="js/CheerPopup.js" defer></script>
</html>

<!--
<script>

//「閉じる」ボタンの動き
    const close = document.getElementById('close');  	//id "close"が
    close.addEventListener('click', () => {  			//clickされたら
    popWin.style.display = 'none';  					//popWinのdisplayがなくなる
    });

</script>
-->