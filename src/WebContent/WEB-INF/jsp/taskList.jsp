<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/taskregister_popup.css">
<script src="/Forza/js/TaskRegist.js" defer></script>
</head>
<body>


<p id="date"></p> <!-- 「[ログインした日付]のタスク」と表示される-->


<input type="button" value="+" onclick="onButtonClick()" id ="click-btn"/>
<div id="popup-wrapper">
  <div id="popup-inside">
    <div id="close">閉じる</div>
      <div id="message">
     		<form method="POST" action="/Forza/TaskRegistServlet">
            タスクの名前：<input type="text" name="task_name"><br>
            <br>
            カスタムセット：
                <select id="custom" name="customset_id">
                    <option value="work">仕事</option>
                    <option value="health">健康</option>
                    <option value="other">その他</option>
                </select>
            <br>
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
            <input type="submit" name="REGIST" value="追加" onClick="alert('追加しました！');">
            </form>

    </div>
  </div>
</div>



<table id="list">

            <tr>
                <th>チェックボックス</th><th>タスクの名前</th><th>削除ボタン</th> <!-- タスクリストに載せる項目（ある程度整ったら消す）-->
            </tr>
            <c:forEach var="e" items="${list}" >

            	<tr class="data_row">
	            	<td><input type="checkbox" name="check" value="ok"></td>
	            	<td><input	 type="text" name="task_name" value="${e.task_name}"></td>
	            	<td>
	            	<form method="POST" action="/Forza/TaskUpdateDeleteServlet">
	            		<input type="hidden" name="id" value="${e.id}">
	            		<input type="submit" name="SUBMIT" value="削除">
	            	</form>
	            	</td>
            	</tr>

            </c:forEach>

        </table>



</html>



