<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forza|カスタマイズページ</title>
<link rel = "stylesheet" type = "text/css" href = "/Forza/css/mypage_2.css">
<script src="./js/CheerPopup.js"></script>
</head>
<body>
<div class="wrapper">
<form method="POST" action="/Forza/CustomSetServlet" id="login_form'">
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
     <div class="bg">
          <div class="upload">
            <h3>背景画像アップロード:　　　　　　
            <input type="submit" name="UPLOAD" value="アップロード"></h3>
          </div>
       <div class="custom">
            <h3>カスタムセット　　　　　　　　　</h3>
         <div class="hamburger">
            <span></span>
            <span></span>
            <span></span>
         </div>
         <nav class="globalMenuSp">
           <ul>
             <li><a href="#">Menu1</a></li>
             <li><a href="#">Menu2</a></li>
             <li><a href="#">Menu3</a></li>
             <li><a href="#">Menu4</a></li>
             <li><a href="#">Menu5</a></li>
           </ul>
         </nav>
       </div>
     </div>

</form>
</div>
</body>
</html>