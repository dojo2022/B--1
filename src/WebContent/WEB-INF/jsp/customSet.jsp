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
<header id="header">
	<div class="header_logo">
    <h1 style="padding-left: 0px;padding-bottom: 0px;padding-right: 0px;padding-top: 0px;"><a href="/Forza/TopServlet">Forza</a></h1>
	</div>
    <div class="newsWrapper">
        <div class="news">
            <br class="newsBr">
            <ul>
				<li>お知らせ：</li>
				<c:forEach var="n" items="${news}">
					<li>${n.remind_name}は${n.remind_date}です。</li>
				</c:forEach>
				<c:forEach var="h" items="${holiday}">
					<li>${h.dayOfWeek}は休日です。</li>
				</c:forEach>
                </ul>
            </div>
           </div>
    <nav style="margin-left: 0px; z-index:1; background-color:white;">
    <ul style="height: 50px;padding-left: 0px;margin-bottom: 0px;margin-top: 0px;">
      <li class="has-child">
	      <a href="#" style="height: 50px;padding-bottom: 0px;padding-top: 0px;padding-left: 0px;padding-right: 0px;" class="menu">
	      <img class="icon_image" src="${iconImage.icon_image}"></img>
	      	menu
	      </a>
        <ul>
        <li><a href="/Forza/PersonalOptionServlet">一般設定</a></li>
        <li><a href="/Forza/CustomSetServlet">カスタマイズ</a></li>
        <li><a href="/Forza/TrophyServlet?loginCount=${loginCount}&taskCount=${TaskCount}">実績</a></li>
        <li><a href="/Forza/LogoutServlet">ログアウト</a></li>
        </ul>
      </li>
    </ul>
  </nav>

  </header>
<!-- メイン -->


		<div class="background">
			<img class="backgound_img" alt="background" src="${background}">
		</div>


     <div class="bg">
     <form action="/Forza/CustomSetServlet" method="post" enctype="multipart/form-data">
          <div class="upload">
            <h3>背景画像アップロード:　　　　　　　　　　　
          <input type="file" name="BACK" accept="image/*" onchange="previewImage(this);"><br>
		 <canvas id="preview" style="max-width:30px;"></canvas><br>
            <input type="submit"  style="width: 100px; height: 45px;" name="UPLOAD" value="アップロード"></h3>
          </div>
		</form>
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
			              <form method="POST" action="/Forza/CustomSetServlet" id="Custom_form'" enctype="multipart/form-data">
                             <label class="add_new_customset">
	                             <input type="text" style="width: 200px; height: 30px;" name="ADDTEXT" id="DATA1">
	                             <input type="submit"  style="width: 70px; height: 35px;" name="data1" value="+新規追加" >
                             </label>
                          </form>

                        </div>

                      <div class="clickableTable" id="hidouki">
	                  <c:forEach var="e" items="${customsetlists}" >
	                      <div class="clickableLine">
                             <div class="clickableTitle">${e.customset_name}</div>
                             <div class="hiddenLine">
<!-- カスタムセット新規追加 -->
                             <form method="POST" action="/Forza/CustomSetServlet" name="CUSTOM_CHEER" enctype="multipart/form-data">
                             <div class="new_cheer_image">
                             	<input type="file" name="CHEER" accept="image/*" >
                               <div class="new_cheer_text">
                             	<input type="text" style="width: 150px; height: 30px;" name="ADDMESSAGE" >
                             	<input type="submit" name="data" value="+新規追加" >
                               </div>
<!-- ここまで -->
							<hr>
                             </div>
                             </form>
                                <c:forEach var="custom" items="${e.cheers}" >
                                 <form method="POST" action="/Forza/CustomSetServlet">
                                  <div class="postCustomset">
                                  <input type="hidden" class="reviewId" value="${custom.customset_id}">
                                <div class="edit">
                                  <label><input type="submit" style="width: 45px; height: 55px;" name="EDITT" value="編集"></label>
                                </div>
                                     <div class="postLeft">
					                  <img class="cheer-image" src="${custom.cheer_image}"></img><br>
				                      </div>
				                     <div class="bg1">
				                      <div class="postcenter">
					                   <input type="text" name="message" class="update_cheer_text" value="${custom.cheer_message}">
				                      </div>
				                     </div>
                                  </div>
                                  </form>
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