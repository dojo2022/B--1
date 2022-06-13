<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/taskregister_popup.css">
        <script src="TaskRegist.js"></script>
    </head>
    <body>
        <div id="popup">＋</div>
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
</html>