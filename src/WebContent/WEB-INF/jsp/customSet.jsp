<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forza|カスタマイズページ</title>
<link rel = "stylesheet" type = "text/css" href = "/Forza/css/mypage_2.css">
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
          <form method="post" enctype="multipart/form-data">
           <input type="file" name="avatar">
          </form>
            <input type="submit" name="UPLOAD" value="アップロード"></h3>
          </div>

       <div class="custom">
       <%--
       <input id="acd-check1" class="acd-check" type="checkbox">

         <label class="acd-label" for="acd-check1"><h2>カスタムセット</h2></label>

       <div class="acd-content">
          <div class="submit">
              <input type="submit" name="ADDNEW" value="＋新規追加">
		  </div>
       </div>
       --%>
           <div class="customname">
            <h3>カスタムセット:　　　　　　　　　</h3>
           </div>


      <!-- <hamburger menu -->
			<div class="drawer">
	            <!-- ハンバーガーメニュー表示・非表示切り替え -->
	            <input type="checkbox" id="drawer-check" class="drawer-hidden" >
	            <!-- ハンバーガーアイコン -->
	            <label for="drawer-check" class="drawer-open"><span></span></label>
		            <nav class="drawer-content">
		              <div class="block">
			            <div class="submit">
			             <div class="addnew">
			              <form method="POST" action="/Forza/CustomSetServlet" id="Custom_form'">
                             <label><input type="text" style="width: 200px; height: 30px;" name="ADDTEXT">
                             <input type="submit" name="ADDNEW" value="+新規追加"></label>
                          </form>
                         </div>
                               <table class="list">
                          <c:forEach var="e" items="${List}" >
                           <tr class="list">
                            <td>${e.customset_name}</td>

                           </tr>
                          </c:forEach>
                        </table>
			            </div>
			          </div>
		            </nav>
			 </div>

         </div>
       </div>
</form>
</div>

</body>
</html>