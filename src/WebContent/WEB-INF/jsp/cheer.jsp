<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>褒めるポップアップ</title>
<link rel="stylesheet" href="css/cheer_popup.css">
<script src="CheerPopup.js"></script>
</head>

<body>
    <input type="checkbox" name="checkbox">
        <div id="popWin">
            <div class="pop-win">
            		${cheer.cheer_image}
	                <br>
	                ${cheer.cheer_message}
                <div id="close"><img src="images/check.png"></div>
            </div>
        </div>
</body>
</html>

<!--
<script>
    const close = document.getElementById('close');
    close.addEventListener('click', () => {
    popWin.style.display = 'none';
    });
</script>
-->