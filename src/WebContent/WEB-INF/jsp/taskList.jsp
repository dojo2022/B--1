<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/Forza/TaskUpdateDeleteServlet">
<p id="date"></p> <!-- 「[ログインした日付]のタスク」と表示される-->
<table id="list">

            <tr>
                <th>チェックボックス</th><th>タスクの名前</th><th>削除ボタン</th> <!-- タスクリストに載せる項目（ある程度整ったら消す）-->
            </tr>
            <c:forEach var="e" items="${list}" >

            	<tr class="data_row"><td><input type="checkbox" name="check" value="ok"></td><td><input	 type="text" name="number" value="${e.task_name}"></td><td><input type="submit" name="SUBMIT" value="削除"></td></tr>


            </c:forEach>

        </table>
</form>
<div id="popup">Click</div>
        <div id="popWin">
            <div class="pop-win">
            タイトル：<input type="text" name="title"><br>
            <br>
            カスタムセット：
                <select id="custom" name="custom">
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
                <input type="checkbox" name="loop" value="e_custom"><input type="text" name="custom" class="txt1">日おき<br>
            <br>
            繰り返しの期間：カレンダーから選択
            <br>
            メモ：<textarea name="task_memo"></textarea><br>
            <br>
            <input type="submit" name="REGIST" value="追加" onClick="alert('追加しました！');">
            <div id="close">閉じる</div>
        </div>
        </div>
</body>
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
    const popup = document.getElementById('popup');
    const close = document.getElementById('close');
    const popWin = document.getElementById('popWin');
    popup.addEventListener('click', () => {
    popWin.style.display = 'flex';
    });
    close.addEventListener('click', () => {
    popWin.style.display = 'none';
    });
	// ページをreloadする方法
	// reloadの基本的な使い方
	/*function doReload() {

	    // reloadメソッドによりページをリロード
	    window.location.reload();
	}

	window.addEventListener('SUBMIT', function () {

	    // ページ表示完了した5秒後にリロード
	    setTimeout(doReload, 5000);
	});*/
</script>
</html>



