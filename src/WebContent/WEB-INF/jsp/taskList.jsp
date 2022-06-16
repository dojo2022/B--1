<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/taskregister_popup.css">
<script src="Forza/js/TaskRegists.js" defer></script>
</head>
<body>


<p id="date"></p> <!-- 「[ログインした日付]のタスク」と表示される-->
<button id="btn">+</button>
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
<!--Creates the popup body-->
<div class="popup-overlay">
  <!--Creates the popup content-->
   <div class="popup-content">
      <h2>Pop-Up</h2>
      <p> This is an example pop-up that you can make using jQuery.</p>
     <!--popup's close button-->
      <button class="close">Close</button>    </div>
</div>
<!--Content shown when popup is not displayed-->
<h2>jQuery Pop-Up Example</h2>
<button class="open">Open</button>


<script>
    function recalc() {
		const now = new Date();
		const year = now.getFullYear();
		let month = now.getMonth();
		const date = now.getDate();

		month = month +1;

		document.getElementById('date').textContent
		= year + '年' + month + '月' + date + '日' + 'のタスク';
		refresh();
	} recalc();


</script>
</html>



