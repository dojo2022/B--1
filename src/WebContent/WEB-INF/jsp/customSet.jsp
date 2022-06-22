<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forza|カスタマイズページ</title>
<link rel = "stylesheet" type = "text/css" href = "/Forza/css/mypage_2.css">
<script type="text/javascript" src="./js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="./js/jquery-ui.min.js"></script>

<script type="text/javascript" src="./js/CustomSet.js"></script>
</head>
<body>
<div class="wrapper">
<!-- <form method="POST" action="/Forza/CustomSetServlet" id="login_form'"> -->
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
   <div class="background">
			<img class="backgound_img" alt="background" src="${myBackGround}">
        </div>
     <div class="bg">
          <div class="upload">
            <h3>背景画像アップロード:　　　　　　　　　　　
          <input type="file" name="IMAGE" accept="image/*" onchange="previewImage(this);"><br>
		 <canvas id="preview" style="max-width:30px;"></canvas><br>
            <input type="submit" name="UPLOAD" value="アップロード"></h3>
          </div>

       <div class="custom">
           <div class="customname">
            <h3>カスタムセット:　　　　　　　　　</h3>
           </div>


      <!-- <hamburger menu -->
			<div class="drawer">
	            <!-- ハンバーガーメニュー表示・非表示切り替え -->
	            <input type="checkbox" id="drawer-check" class="drawer-hidden" >
	            <!-- ハンバーガーアイコン -->
	            <label for="drawer-check" class="drawer-open"><span></span></label>
		            <div class="drawer-content">
		              <div class="block">
			            <div class="submit">
			             <div class="addnew">
			              <form method="POST" action="/Forza/CustomSetServlet" id="Custom_form'">
                             <label><input type="text" style="width: 200px; height: 30px;" name="ADDTEXT">
                             <input type="submit" name="ADDNEW" value="+新規追加"></label>
                          </form>

                        </div>

                      <div class="clickableTable">
	                  <c:forEach var="e" items="${customsetlists}" >
	                      <div class="clickableLine">
                             <div class="clickableTitle">${e.customset_name}</div>
                             <div class="hiddenLine">
                                <c:forEach var="custom" items="${e.cheers}" >
                                  <div class="postCustomset">
                                  <input type="hidden" class="reviewId" value="${custom.customset_id}">
                                     <div class="postLeft">
					                  <img class="cheer-image" src="${custom.cheer_image}"></img>
				                      </div>
				                      <div class="postcenter">
					                   <div>${custom.cheer_message}</div>
				                      </div>
                                  </div>
                                </c:forEach>
                              </div>

	                       </div>
	                  </c:forEach>
	                  </div>
			           </div>
			          </div>
		            </div>
			 </div>

         </div>
       </div>
</div>

</body>
</html>