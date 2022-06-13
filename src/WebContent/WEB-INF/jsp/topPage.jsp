<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Forza｜TopPage</title>
	<link rel = "stylesheet" type = "text/css" href = "/Forza/css/top.css">
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
                <input type="button" id="btn" value="myPage">
            </div>
		</header>
<!-- メイン -->
	<main class="main">
        <div class="calendar">
            カレンダー
        </div>
        <div class="task">
            タスクリスト
        </div>

        <div class="memo">
			<form id ="topMemoForm" method="POST" action="/Folza/topMemoServlet">
				<table>
					<tr><td><label for="topMemo">Memo</label></td><td><input type="submit" class="submit" value="更新"></td></tr>
					<tr><td colspan =2><textarea id="topMemo" name="topMemo" rows="20" cols="40"></textarea></td></tr>
				</table>

			</form>

        </div>

        <div class="trophy">
            トロフィー
        </div>
</main>
<!-- フッタ－ -->
	<footer>
        <!-- 今回は無し -->
	</footer>
</div>
</body>
</html>