<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            		<tr><th>ID｜</th><th>ユーザーID｜</th><th>カスタムセットID｜</th><th>画像｜</th><th>メッセージ</th></tr>
			        <c:forEach var="e" items="${cheerlist}" >
			    		<tr class="data_row"><td>${e.id}</td><td>${e.user_id}</td><td>${e.customset_id}</td><td>${e.cheer_image}</td><td>${e.cheer_message}</td></tr>
			    	</c:forEach>
                <div id="close"><img src="images/check.png"></div>
            </div>
        </div>
</body>
</html>
<!--<script src="CheerPopup.js"></script>-->

<script>
    const close = document.getElementById('close');
    close.addEventListener('click', () => {
    popWin.style.display = 'none';
    });
</script>