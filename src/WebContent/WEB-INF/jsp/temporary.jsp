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
<table id="list">

            <tr>
                <th>チェックボックス</th><th>タスクの名前</th><th>削除ボタン</th> <!-- タスクリストに載せる項目（ある程度整ったら消す）-->
            </tr>
            <c:forEach var="e" items="${list}" >
            <tr class="data_row"><td><input type="checkbox" name="check" value="ok"></td><td>${e.task_name}</td><td><input type="submit" name="SUBMIT" value="削除"></td></tr>
            </c:forEach>
        </table>
</body>
</html>