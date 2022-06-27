<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/taskregister_popup.css">
 <script src="https://cdn.jsdelivr.net/npm/party-js@latest/bundle/party.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="js/TaskRegist.js" defer></script>

</head>
<body>


<h2 id="date">${task_date}のタスク</h2> <!-- 「[ログインした日付]のタスク」と表示される-->
<div class=new-add align="right" >
<input type="button" value="+新規追加" onclick="onButtonClick()" id ="click-btn"/>
</div>
<div id="popup-wrapper">
  <div id="popup-inside">
    <div id="close">閉じる</div>
      <div id="message">
     		<form method="POST" action="/Forza/TaskRegistServlet">
            タスクの名前：<input type="text" name="task_name"><br>
            <br>
            カスタムセット：
                <select id="customset_name" name="customset_id">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
            <br>
            優先度
            	<select id="priority" name="priority">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
            <br>
            繰り返し設定：
                <input type="checkbox" name="loop" value="e_day">毎日
                <input type="checkbox" name="loop" value="e_week">毎週
                <input type="checkbox" name="loop" value="e_month">毎月
                <input type="checkbox" name="loop" value="e_year">毎年

            <br>
            繰り返しの期間：カレンダーから選択
            <br>
            メモ：<textarea name="task_memo"></textarea><br>
            <br>
            <input type="hidden" name="id" value="">
            <input type="hidden" name="user_id" value="${lists[0].user_id}">
            <input type="hidden" name="task_id" value="100">
            <input type="hidden" name="task_judge" value="0">
            <input type="hidden" name="task_date" value="${lists[0].task_date}">
            <input type="submit" name="REGIST" value="追加" id="addBtn" onClick="alert('追加しました！');">
            </form>

    </div>
  </div>
</div>



<table id="lists">

            <tr>
                <th>　　　　　</th><th>　　　　　<br></th><th>　　　　　</th>
            </tr>
             <c:forEach var="e" items="${lists}" varStatus="status">

            	<tr class="data_row">

	            	<td><input type="hidden" name="ID" value="1">
	            	    <input type="checkbox" name="CUSTOMSET_ID" value="1" onchange="goAjax()" id="chk_box">


	            <div id="popWin">
         			<!-- 紙吹雪のためのdiv -->
            		<div id="particles-js"></div>
					<div id="wrapper">
        				<!-- ポップアップウィンドウ -->
            			<div class="popwin-inside">
	            		<h2>タスク完了！</h2>
				        <!-- カスタムセットの画像を表示 -->
				        <div id="cheerImage"></div>

						<br>
				    	<!-- カスタムセットのメッセージ表示 -->
				    	<div id="cheerMessage"></div>
				    	 <br>
				    	 <!-- 閉じるボタン -->
	                	<div id="popupclose" onmousedown="party.confetti(this)">閉じる</div>
            		</div>
        	</div>
		</div>
					</td>
	            	<td><input	 type="button" name="task_name" value="${e.task_name}"  id ="click-name${status.count}">
					</td>
				<td>
					<div class="edit-popup-wrapper" id="edit-popup-wrapper${status.count}">
					  <div class="edit-popup-inside" id="edit-popup-inside${status.count}">
					    <div class="edit-close" id="edit-close${status.count}">閉じる</div>
					      <div class="edit-message" id="edit-message${status.count}">
					     		<form method="POST" action="/Forza/TaskUpdateDeleteServlet">
					            タスクの名前：<input type="text" name="task_name" value="${e.task_name}"><br>
					            <br>
					            カスタムセット：
					                <select id="customset_name" name="customset_id">
					                    <option value="1">1</option>
					                    <option value="2">2</option>
					                    <option value="3">3</option>
					                </select>
					            <br>
					            優先度
					            	<select id="priority" name="priority">
					                    <option value="1">1</option>
					                    <option value="2">2</option>
					                    <option value="3">3</option>
					                </select>
					            <br>
					            繰り返し設定：
					                <input type="checkbox" name="loop" value="e_day">毎日
					                <input type="checkbox" name="loop" value="e_week">毎週
					                <input type="checkbox" name="loop" value="e_month">毎月
					                <input type="checkbox" name="loop" value="e_year">毎年
					            <!-- 繰り返しの期間：カレンダーから選択 -->
					            <br>
					            メモ：<textarea name="task_memo"></textarea><br>
					            <br>
					            <input type="hidden" name="id" value="${e.id}">
					            <input type="hidden" name="user_id" value="${e.user_id}">
					            <input type="hidden" name="task_id" value="${e.task_id}">
					            <input type="hidden" name="task_judge" value="0">
					            <input type="hidden" name="task_date" value="${e.task_date}">
					            <input type="submit" name="SUBMIT" value="更新" id="updateBtn" onClick="alert('更新しました！');">
					            </form>

					    </div>
					  </div>
					</div>
				</td>
	            	<td><form method="POST" action="/Forza/TaskUpdateDeleteServlet">
	            		<input type="hidden" name="id" value="${e.id}">
	            		<input type="submit" name="SUBMIT" value="削除" id="delete">
	            	</form>
	            	</td>
            	</tr>

            </c:forEach>

        </table>

<!-- 全面紙吹雪のjsダウンロード -->
	<script src="http://cdn.jsdelivr.net/particles.js/2.0.0/particles.min.js"></script>
<!-- 自作のjs読み込み
	<script src="js/CheerPopup.js" defer></script>
-->

</body>
</html>



